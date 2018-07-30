package lc.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class P68TextJustification {
  public List<String> fullJustify(String[] words, int maxWidth) {

    List<String> output = new ArrayList<>();
    List<Integer> indices = new ArrayList<>();
    int lens = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (lens + indices.size() + word.length() > maxWidth) {
        output.add(buildLine(words, maxWidth, indices, lens));
        lens = word.length();
        indices.clear();
        indices.add(i);
      } else {
        lens += word.length();
        indices.add(i);
      }
    }
    output.add(buildLastLine(words, maxWidth, indices));
    return output;
  }

  public static String buildLine(String[] words, int maxWidth, List<Integer> indices, int lens) {
    StringBuilder sb = new StringBuilder();

    int totalSpaces = maxWidth - lens;
    sb.append(words[indices.get(0)]);
    switch (indices.size()) {
      case 1:
        for (int i = 0; i < totalSpaces; i++)
          sb.append(' ');
        break;
      case 2:
        for (int i = 0; i < totalSpaces; i++)
          sb.append(' ');
        sb.append(words[indices.get(1)]);
        break;
      default:
        int d = indices.size() - 1;
        int space = totalSpaces / d;
        int additionalSpace = totalSpaces % d;
        for (int j = 1; j < indices.size(); j++) {
          for (int i = 0; i < space; i++)
            sb.append(' ');
          if (additionalSpace-- > 0)
            sb.append(' ');
          sb.append(words[indices.get(j)]);
        }
        break;
    }
    return sb.toString();
  }

  static String buildLastLine(String[] words, int maxWidth, List<Integer> indices) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (; i < indices.size() - 1; i++)
      sb.append(words[indices.get(i)] + ' ');
    sb.append(words[indices.get(i)]);
    int s = maxWidth - sb.length();
    for (i = 0; i < s; i++)
      sb.append(' ');
    return sb.toString();
  }

  static void out(List<String> lines) {
    StringJoiner sj = new StringJoiner(",\n");
    lines.forEach(l -> sj.add(l));
    System.out.println(sj.toString());
  }

  public static void main(String[] args) {
    P68TextJustification p = new P68TextJustification();
    out(p.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."},
        16));
    out(p.fullJustify(new String[] {"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
    out(p
        .fullJustify(
            new String[] {"Science", "is", "what", "we", "understand", "well", "enough", "to",
                "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
            20));

    System.out.println(P68TextJustification.buildLine(
        new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16,
        Arrays.asList(new Integer[] {3, 4, 5}), 13));

    System.out.println(P68TextJustification.buildLine(
        new String[] {"Science", "is", "what", "we", "understand", "well", "enough", "to",
            "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
        20, Arrays.asList(new Integer[] {0, 1, 2, 3}), 15));

  }
}

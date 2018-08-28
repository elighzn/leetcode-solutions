package lc.google.easy;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

public class P804UniqueMorseCodeWords {
  static final String[] letters = new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
      "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
      "..-", "...-", ".--", "-..-", "-.--", "--.."};

  public int uniqueMorseRepresentations(String[] words) {
    Set<String> set = new HashSet<>();


    for (String in : words) {
      String concatenation = new String();
      for (int i = 0; i < in.length(); i++) {
        concatenation += getCode(in.charAt(i));
      }
      set.add(concatenation);
    }
    return set.size();
  }

  static String getCode(char letter) {
    return letters[letter - 'a'];
  }

  public static void main(String[] args) {
    String[] input = new String[] {"gin", "zen", "gig", "msg"};
    P804UniqueMorseCodeWords p = new P804UniqueMorseCodeWords();
    Assert.assertEquals(2, p.uniqueMorseRepresentations(input));
  }

}

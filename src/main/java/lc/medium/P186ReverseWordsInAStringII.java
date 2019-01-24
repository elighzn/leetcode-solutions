package lc.medium;

import java.util.Arrays;

public class P186ReverseWordsInAStringII {
  public void reverseWords(char[] str) {
    if (str == null || str.length == 0)
      return;

    char[] arr = new char[str.length];

    int cur = 0, prev = 0;
    while (cur < str.length) {
      if (str[cur] == ' ') {
        int len = cur - prev;
        for (int i = 0; i < len; i++)
          arr[arr.length - cur + i] = str[prev + i];
        prev = cur + 1;
      }
      cur++;
    }
    str = null;
    str = Arrays.copyOf(arr, 0);
  }

  public static void main(String[] args) {
    P186ReverseWordsInAStringII p = new P186ReverseWordsInAStringII();
    char[] input = "the sky is blue".toCharArray();
    p.reverseWords(input);
    System.out.println(input);
  }

}

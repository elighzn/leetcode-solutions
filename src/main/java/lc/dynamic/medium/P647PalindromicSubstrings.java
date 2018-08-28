package lc.dynamic.medium;

import org.junit.Assert;

public class P647PalindromicSubstrings {

  public int countSubstrings(String s) {
    if (s == null || s.length() < 1)
      return 0;

    int total = s.length();
    final int H1 = (s.length() - 2) / 2;

    boolean[] b = new boolean[s.length()];

    for (int i = 0; i < b.length - 1; i++)
      if (s.charAt(i) == s.charAt(i + 1)) {
        b[i] = true;
        total++;
      }

    for (int l = 1; l <= H1; l++) {
      for (int i = l; i < s.length() - l - 1; i++) {
        if (b[i])
          if (s.charAt(i - l) == s.charAt(i + l + 1))
            total++;
          else
            b[i] = false;
      }
    }

    for (int i = 0; i < b.length; i++)
      b[i] = true;

    final int H2 = (s.length() - 1) / 2;

    for (int l = 1; l <= H2; l++) {
      for (int i = l; i < s.length() - l; i++) {
        if (b[i]) {
          if (s.charAt(i - l) == s.charAt(i + l))
            total++;
          else
            b[i] = false;
        }
      }
    }
    return total;
  }

  public static void main(String[] args) {
    P647PalindromicSubstrings p = new P647PalindromicSubstrings();
    Assert.assertEquals(15, p.countSubstrings("aaaaa"));
    Assert.assertEquals(3, p.countSubstrings("abc"));
    Assert.assertEquals(6, p.countSubstrings("aaa"));

  }
}

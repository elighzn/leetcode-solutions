package lc;

import org.junit.Assert;

public class P9PalindromeNumber {
  public boolean isPalindrome(int x) {
    String s = String.valueOf(x);
    int n = s.length();
    int half = s.length() / 2;
    for (int i = 0; i < half; i++) {
      if (s.charAt(i) != s.charAt(n - i - 1))
        return false;
    }
    return true;
  }

  public boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }

    int result = 0;
    int origin = x;
    while (x != 0) {
      int last = x % 10;
      int newResult = result * 10 + last;
      if ((newResult - last) / 10 != result) {
        return false;
      }
      result = newResult;
      x = x / 10;
    }
    if (result == origin) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P9PalindromeNumber p = new P9PalindromeNumber();

    Assert.assertEquals(false, p.isPalindrome(-111));
    Assert.assertEquals(true, p.isPalindrome(131));
  }

}

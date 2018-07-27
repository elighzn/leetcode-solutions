package lc.easy;

import org.junit.Assert;

public class P709ToLowerCase {

  public String toLowerCase(String str) {
    if (str == null || str.isEmpty())
      return str;

    char[] charArray = str.toCharArray();
    final int a = 'a' - 'A';
    for (int i = 0; i < charArray.length; i++) {
      charArray[i] =
          charArray[i] >= 'A' && charArray[i] <= 'Z' ? (char) (charArray[i] + a) : charArray[i];
    }

    return String.valueOf(charArray);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P709ToLowerCase p = new P709ToLowerCase();
    Assert.assertEquals(null, p.toLowerCase(null));
    Assert.assertEquals("", p.toLowerCase(""));
    Assert.assertEquals("hello", p.toLowerCase("Hello"));

  }

}

package lc;

import org.junit.Assert;

public class P8StringToInteger {

  public int myAtoi(String str) {
    int sum = 0;
    str = str.trim();

    if (!str.isEmpty()) {
      char firstChar = str.charAt(0);
      boolean hasSign = firstChar == '-' || firstChar == '+';
      boolean negative = firstChar == '-' ? true : false;

      char[] charArray = str.toCharArray();
      int i = hasSign ? 1 : 0;
      int limit = negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

      while (i < charArray.length && isNum(charArray[i])) {
        try {
          sum = Math.multiplyExact(sum, 10);
          sum = negative ? Math.subtractExact(sum, charArray[i] - '0')
              : Math.addExact(sum, charArray[i] - '0');
        } catch (ArithmeticException ex) {
          return limit;
        }
        i++;
      }
    }
    return sum;
  }

  boolean isNum(char c) {
    return c >= '0' && c <= '9';
  }

  public static void main(String[] args) {
    P8StringToInteger p = new P8StringToInteger();

    Assert.assertEquals(-2147483648, p.myAtoi("-91283472332"));
    Assert.assertEquals(1, p.myAtoi("+1"));
    Assert.assertEquals(42, p.myAtoi("42"));
    Assert.assertEquals(-42, p.myAtoi("-42"));

  }

}

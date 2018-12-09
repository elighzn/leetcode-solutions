package lc.medium;

import org.junit.Assert;

public class P29DivideTwoInteger {

  public int divide(int dividend, int divisor) {
    if (divisor == 1)
      return dividend;
    else if (dividend == Integer.MIN_VALUE && divisor == -1)
      return Integer.MAX_VALUE;
    else if (dividend == Integer.MAX_VALUE && divisor == -1)
      return -Integer.MAX_VALUE;

    boolean sign = (dividend > 0) ^ (divisor > 0);
    int q = 1;
    long div = Math.abs((long) dividend), d = Math.abs((long) divisor);
    while (div > d) {
      div = div >> 1;
      q = q << 1;
    }
    while (div < d) {
      div += d;
      q--;
    }
    return sign ? -q : q;
  }

  public static void main(String[] args) {
    P29DivideTwoInteger p = new P29DivideTwoInteger();
    Assert.assertEquals((Integer.MAX_VALUE/3), p.divide(Integer.MAX_VALUE, 3));
    Assert.assertEquals(4, p.divide(8, 2));
    Assert.assertEquals((Integer.MAX_VALUE/-1), p.divide(Integer.MAX_VALUE, -1));
    Assert.assertEquals((Integer.MAX_VALUE/-2), p.divide(Integer.MAX_VALUE, -2));
    Assert.assertEquals(3, p.divide(10, 3));
    Assert.assertEquals(-2, p.divide(7, -3));
    Assert.assertEquals(-1073741824, p.divide(Integer.MIN_VALUE, 2));
    Assert.assertEquals(Integer.MIN_VALUE, p.divide(Integer.MIN_VALUE, 1));
    Assert.assertEquals(Integer.MAX_VALUE, p.divide(Integer.MIN_VALUE, -1));
  }

}

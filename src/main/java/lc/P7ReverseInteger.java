package lc;

import org.junit.Assert;

public class P7ReverseInteger {

  public int reverse(int x) {
    boolean neg = x < 0;
    int y = neg ? -x : x;
    int result = 0;
    while (y > 0) {
      int remainder = y % 10;
      y /= 10;
      if ((Integer.MAX_VALUE - remainder) / 10 < result)
        return 0;
      result = result * 10 + remainder;
    }
    if (neg) {
      int tmp = -result;
      if (tmp > 0)
        return 0;
      else
        result = tmp;
    }
    return result;
  }

  public int reverse2(int x) {
    try {
      if (x < 0) {
        String str = String.valueOf(x);
        return Integer
            .valueOf(new StringBuilder(str.substring(1, str.length())).reverse().toString()) * -1;
      } else {
        return Integer.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
      }

    } catch (NumberFormatException nfe) {
      return 0;
    }

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P7ReverseInteger p = new P7ReverseInteger();

    long ts1, ts2;

    ts1 = System.nanoTime();
    Assert.assertEquals(0, p.reverse(1534236469));
    Assert.assertEquals(123, p.reverse(321));
    Assert.assertEquals(-321, p.reverse(-123));
    Assert.assertEquals(0, p.reverse(Integer.MAX_VALUE));
    Assert.assertEquals(0, p.reverse(Integer.MIN_VALUE));
    ts2 = System.nanoTime();
    System.out.println(ts2 - ts1);

    ts1 = System.nanoTime();
    Assert.assertEquals(0, p.reverse2(1534236469));
    Assert.assertEquals(123, p.reverse2(321));
    Assert.assertEquals(-321, p.reverse2(-123));
    Assert.assertEquals(0, p.reverse2(Integer.MAX_VALUE));
    Assert.assertEquals(0, p.reverse2(Integer.MIN_VALUE));
    ts2 = System.nanoTime();
    System.out.println(ts2 - ts1);
  }

}

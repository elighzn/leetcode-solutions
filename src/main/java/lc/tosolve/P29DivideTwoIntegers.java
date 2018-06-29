package lc.tosolve;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3 Output: 3
 * 
 * Example 2:
 * 
 * Input: dividend = 7, divisor = -3 Output: -2
 * 
 * Note:
 * 
 * Both dividend and divisor will be 32-bit signed integers. The divisor will never be 0. Assume we
 * are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231, 231 − 1]. For the purpose of this problem, assume that your function returns 231 −
 * 1 when the division result overflows.
 * 
 * @author sfumato
 *
 */
public class P29DivideTwoIntegers {

  public int divide(int dividend, int divisor) {

    if (divisor == 0)
      throw new RuntimeException("Divisors cannot be 0.");

    int remainder = dividend;
    if (remainder < 0) {
      remainder = -dividend;
    }
    int d = divisor;
    if (d < 0)
      d = -divisor;

    boolean sameSign = (dividend >= 0) ^ (divisor >= 0) ? false : true;

    int overflowCheck = Integer.MAX_VALUE - 1;

    int result = 0;
    while (remainder >= d && result < overflowCheck) {
      remainder -= d;
      result++;
      if (result == overflowCheck)
        System.out.println(result);
    }
    
    if (!sameSign)
      if (Integer.MIN_VALUE + result >= 0)
        return Integer.MAX_VALUE;
      else
        result = -result;
    return result;
  }

  boolean isOverflow(int left, int right) {
    return right > 0 ? Integer.MAX_VALUE - right < left : Integer.MIN_VALUE - right > left;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    P29DivideTwoIntegers p = new P29DivideTwoIntegers();
    int a;

    a = p.divide(-2147483648, -1);
    System.out.println(a);
    assert a == 2147483647;

    // a = p.divide(10, 3);
    // System.out.println(a);
    // assert a == 3;
    //
    // a = p.divide(7, -3);
    // System.out.println(a);
    // assert a == -2;
    //
    // a = p.divide(0, 1);
    // System.out.println(a);
    // assert a == 0;
    //
    // a = p.divide(-1, 1);
    // System.out.println(a);
    // assert a == -1;
  }

}

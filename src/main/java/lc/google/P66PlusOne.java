package lc.google;

import org.junit.Assert;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of the list, and each
 * element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * 
 * Example 1:
 * 
 * Input: [1,2,3]
 * 
 * Output: [1,2,4]
 * 
 * Explanation: The array represents the integer 123.
 * 
 * Example 2:
 * 
 * Input: [4,3,2,1]
 * <p>
 * Output: [4,3,2,2]
 * 
 * Explanation: The array represents the integer 4321.
 * 
 * @author zli
 *
 */
public class P66PlusOne {

  public int[] plusOne(int[] digits) {
    boolean flag = true;
    int d = digits.length - 1;
    while (flag) {
      if (digits[d] != 9) {
        digits[d]++;
        flag = false;
      } else {
        if (d == 0) {
          digits = addADigit(digits);
          d++;
        }
        digits[d] = 0;
        d--;
      }
    }
    return digits;
  }

  int[] addADigit(int[] digits) {
    int[] temp = new int[digits.length + 1];
    for (int i = 0; i < digits.length; i++) {
      temp[i + 1] = digits[i];
    }
    return temp;
  }

  public static void main(String[] args) {
    P66PlusOne p = new P66PlusOne();

    int[] a, b;

    a = new int[] {1, 2, 3};
    b = new int[] {1, 2, 4};
    Assert.assertArrayEquals(b, p.plusOne(a));

    a = new int[] {4, 3, 2, 1};
    b = new int[] {4, 3, 2, 2};
    Assert.assertArrayEquals(b, p.plusOne(a));

    a = new int[] {0};
    b = new int[] {1};
    Assert.assertArrayEquals(b, p.plusOne(a));

    a = new int[] {9, 9, 9, 9};
    b = new int[] {1, 0, 0, 0, 0};
    Assert.assertArrayEquals(b, p.plusOne(a));

    a = new int[] {9};
    b = new int[] {1, 0};
    Assert.assertArrayEquals(b, p.plusOne(a));
  }

}

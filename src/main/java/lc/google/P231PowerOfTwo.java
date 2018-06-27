package lc.google;

import org.junit.Assert;

/**
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Example 1:
 * 
 * Input: 1
 * 
 * Output: true
 * 
 * Explanation: 20 = 1
 * 
 * Example 2:
 * 
 * Input: 16
 * 
 * Output: true
 * 
 * Explanation: 24 = 16
 * 
 * Example 3:
 * 
 * Input: 218
 * 
 * Output: false
 * 
 * @author zli
 *
 */
public class P231PowerOfTwo {

  public boolean isPowerOfTwo(int n) {
    return n >= 1 && Integer.bitCount(n) == 1;
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P231PowerOfTwo p = new P231PowerOfTwo();
    Assert.assertEquals(true, p.isPowerOfTwo(1));
    Assert.assertEquals(true, p.isPowerOfTwo(16));
    Assert.assertEquals(false, p.isPowerOfTwo(218));
    Assert.assertEquals(false, p.isPowerOfTwo(1073741825));

    // System.out.println(Integer.bitCount(1073741825));


  }

}

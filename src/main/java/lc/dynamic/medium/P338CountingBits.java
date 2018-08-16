package lc.dynamic.medium;

import java.util.Arrays;
import org.junit.Assert;

/**
 * @author zli
 *
 *         Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 *         calculate the number of 1's in their binary representation and return them as an array.
 */
public class P338CountingBits {

  public int[] countBits(int num) {
    if (num < 0) {
      return null;
    }

    int[] ans = new int[num + 1];

    int potN = 1, ct = 0, c = 0;

    for (int i = 1; i < ans.length; i++) {
      if (i == potN) {
        potN *= 2;
        ans[i] = 1;
        ct = 0;
        c = 0;
      } else {
        if (++c % 2 == 0) {
          ct++;
          c = 0;
        }

        ans[i] = 1 + ct + c;
      }
    }
    return ans;
  }

  public static void main(String[] args) {


    P338CountingBits p = new P338CountingBits();
    p.countBits(8);


    Assert.assertArrayEquals(new int[] {0, 1, 1}, p.countBits(2));
    Assert.assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2}, p.countBits(5));
    Assert.assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2, 2, 3, 1}, p.countBits(8));

    Assert.assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1},
        p.countBits(16));
  }
}

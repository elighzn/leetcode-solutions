package lc.dynamic.easy;

import org.junit.Assert;

/**
 * @author sfumato
 *
 *         this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the
 *         ACM P885)
 * 
 *         the paragraph below was copied from his paper (with a little modifications)
 * 
 *         algorithm that operates on arrays: it starts at the left end (element A[1]) and scans
 *         through to the right end (element A[n]), keeping track of the maximum sum subvector seen
 *         so far. The maximum is initially A[0]. Suppose we've solved the problem for A[1 .. i -
 *         1]; how can we extend that to A[1 .. i]? The maximum sum in the first I elements is
 *         either the maximum sum in the first i - 1 elements (which we'll call MaxSoFar), or it is
 *         that of a subvector that ends in position i (which we'll call MaxEndingHere).
 * 
 *         MaxEndingHere is either A[i] plus the previous MaxEndingHere, or just A[i], whichever is
 *         larger.
 */
public class P53MaximumSubarray {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length < 1)
      return 0;

    int maxSoFar = nums[0], maxEndingHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }

  public static void main(String[] args) {
    P53MaximumSubarray p = new P53MaximumSubarray();
    Assert.assertEquals(6, p.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

}

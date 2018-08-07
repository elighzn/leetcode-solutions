package lc.dynamic.easy;

import org.junit.Assert;

public class P198HouseRobber {

  public int rob(int[] nums) {
    if (nums == null || nums.length < 1)
      return 0;

    if (nums.length == 1)
      return nums[0];

    int maxP2 = nums[0];
    int maxP1 = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      int max = Math.max(nums[i] + maxP2, maxP1);
      maxP2 = maxP1;
      maxP1 = max;
    }
    return maxP1;
  }

  public static void main(String[] args) {
    P198HouseRobber p = new P198HouseRobber();
    Assert.assertEquals(4, p.rob(new int[] {1, 2, 3, 1}));
    Assert.assertEquals(12, p.rob(new int[] {2, 7, 9, 3, 1}));
  }

}

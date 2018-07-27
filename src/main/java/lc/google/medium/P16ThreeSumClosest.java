package lc.google.medium;

import java.util.Arrays;
import org.junit.Assert;

public class P16ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    int result = nums[0] + nums[1] + nums[2];
    if (result == target)
      return result;

    Arrays.sort(nums);

    int minDiff = Math.abs(result - target);

    final int n = nums.length - 1;

    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = n;

      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == target) {
          return sum;
        }

        int diff = Math.abs(sum - target);

        if (diff < minDiff) {
          minDiff = diff;
          result = sum;
        }

        if (sum < target)
          j++;
        else
          k--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P16ThreeSumClosest p = new P16ThreeSumClosest();

    Assert.assertEquals(0, p.threeSumClosest(new int[] {0, 0, 0}, 1));
    Assert.assertEquals(2, p.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));

    Assert.assertEquals(0, p.threeSumClosest(new int[] {-1, 2, 3, 5, -2, 1, -4}, 0));
  }

}

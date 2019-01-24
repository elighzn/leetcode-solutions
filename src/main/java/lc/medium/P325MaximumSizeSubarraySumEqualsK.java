package lc.medium;

import java.util.HashMap;

public class P325MaximumSizeSubarraySumEqualsK {
  public int maxSubArrayLen(int[] nums, int k) {
    int sum = 0, max = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (sum == k)
        max = i + 1;
      else if (map.containsKey(sum - k))
        max = Math.max(max, i - map.get(sum - k));
      if (!map.containsKey(sum))
        map.put(sum, i);
      
      System.out.println(map);
    }
    return max;
  }

  public static void main(String[] args) {
    P325MaximumSizeSubarraySumEqualsK p = new P325MaximumSizeSubarraySumEqualsK();
    p.maxSubArrayLen(new int[] {1, -1, 5, -2, 3}, 3);
  }

}

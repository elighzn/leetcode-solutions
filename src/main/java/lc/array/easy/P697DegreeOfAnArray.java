package lc.array.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Assert;

/**
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the
 * maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has
 * the same degree as nums.
 * 
 * Example 1:
 * 
 * Input: [1, 2, 2, 3, 1]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * The input array has a degree of 2 because both elements 1 and 2 appear twice. Of the subarrays
 * that have the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2,
 * 2] The shortest length is 2. So return 2. Example 2: Input: [1,2,2,3,1,4,2] Output: 6
 * 
 * Note:
 * 
 * nums.length will be between 1 and 50,000. nums[i] will be an integer between 0 and 49,999.
 */
public class P697DegreeOfAnArray {

  public int findShortestSubArray(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;

    Map<Integer, Integer> leftIndex = new HashMap<>(), rightIndex = new HashMap<>(),
        count = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      Integer left = leftIndex.get(nums[i]);
      if (left == null)
        leftIndex.put(nums[i], i);
      rightIndex.put(nums[i], i);
      count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
    }

    int degree = Collections.max(count.values());

    int ans = nums.length;

    for (Integer k : count.keySet()) {
      int v = count.get(k);
      if (degree == v) {
        int l = rightIndex.get(k) - leftIndex.get(k) + 1;
        if (l < ans)
          ans = l;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    P697DegreeOfAnArray p = new P697DegreeOfAnArray();
    Assert.assertEquals(2, p.findShortestSubArray(new int[] {1, 2, 2, 3, 1}));
    Assert.assertEquals(6, p.findShortestSubArray(new int[] {1, 2, 2, 3, 1, 4, 2}));
  }

}

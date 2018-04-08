package zli.leetcode.algrithm.tobesolved;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty array of integers, return the k most frequent elements. For example, Given
 * [1,1,1,2,2,3] and k = 2, return [1,2]. Note: You may assume k is always valid, 1 ≤ k ≤ number of
 * unique elements. Your algorithm's time complexity must be better than O(n log n), where n is the
 * array's size.
 *
 */
public class TopKFrequentElements {

  /**
   * @param nums
   * @param k
   * @return
   */
  public List<Integer> topKFrequent(int[] nums, int k) {
    final int N = nums.length;
    Integer[] frequency = new Integer[N];
    for (int i = 0; i < N; i++) {

      frequency[nums[i]] += 1;

    }

    List<Integer> list = Arrays.asList(frequency).subList(0, k);
    return list;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

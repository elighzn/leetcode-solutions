package lc.coursera.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

/**
 * @author zhengli
 * 
 *         Given an array nums, there is a sliding window of size k which is
 *         moving from the very left of the array to the very right. You can
 *         only see the k numbers in the window. Each time the sliding window
 *         moves right by one position. Return the max sliding window.
 * 
 *         Example:
 * 
 *         Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * 
 *         Output: [3,3,5,5,6,7]
 * 
 *         Explanation:
 * 
 *         Window position Max --------------- -----
 * 
 *         [1 3 -1] -3 5 3 6 7 -- 3
 * 
 *         1 [3 -1 -3] 5 3 6 7 -- 3
 * 
 *         1 3 [-1 -3 5] 3 6 7 -- 5
 * 
 *         1 3 -1 [-3 5 3] 6 7 -- 5
 * 
 *         1 3 -1 -3 [5 3 6] 7 -- 6
 * 
 *         1 3 -1 -3 5 [3 6 7] -- 7
 * 
 *         Note: You may assume k is always valid, 1 ≤ k ≤ input array's size
 *         for non-empty array.
 * 
 *         Follow up: Could you solve it in linear time?
 */
public class P239SlidingWindowMaximum {

	public List<Integer> getSLidingWIndowMaximium(int[] nums, int k) {
		List<Integer> ans = new ArrayList<>();
		if (nums == null || nums.length < k)
			return ans;

		int[][] dp = new int[k][nums.length];

		for (int i = 0; i < nums.length; i++) {
			dp[0][i] = nums[i];
		}

		for (int l = 1; l < k; l++) {
			for (int i = 0; i + l < dp[l].length; i++) {
				dp[l][i] = Math.max(dp[l - 1][i], nums[i + l]);
			}
		}

		for (int i = 0; i < nums.length - k + 1; i++) {
			ans.add(dp[k - 1][i]);
		}

		return ans;
	}

	public static void main(String[] args) {
		P239SlidingWindowMaximum p = new P239SlidingWindowMaximum();
		Assert.assertEquals(Arrays.asList(new Integer[] { 3, 3, 5, 5, 6, 7 }),
				p.getSLidingWIndowMaximium(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
	}

}

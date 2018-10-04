package lc.problems;

import java.util.Arrays;

import org.junit.Assert;

/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4] Explanation: rotate
 * 1 steps to the [4,,,1,,,] right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: [-1,-100,3,99] and k = 2
 * 
 * Output: [3,99,-1,-100]
 * 
 * Explanation: rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps to
 * the right: [3,99,-1,-100]
 * 
 * Note:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem. Could you do it in-place with O(1) extra space?
 * 
 * @author zli
 *
 */
public class P189RotateArray {

	public void rotate(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return;

		k %= nums.length;
		if (k == 0)
			return;

		rotate(nums, 0, nums.length - 1);
		rotate(nums, 0, k - 1);
		rotate(nums, k, nums.length - 1);
	}

	void rotate(int[] nums, int lo, int hi) {
		while (lo < hi) {
			int tmp = nums[lo];
			nums[lo++] = nums[hi];
			nums[hi--] = tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P189RotateArray p = new P189RotateArray();
		int[] input;
		int[] expected;
		expected = new int[] { 5, 6, 7, 1, 2, 3, 4 };
		input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		p.rotate(input, 3);
		Assert.assertArrayEquals(expected, input);

		expected = new int[] { 3, 99, -1, -100 };
		input = new int[] { -1, -100, 3, 99 };
		p.rotate(input, 2);
		Assert.assertArrayEquals(expected, input);

	}
}
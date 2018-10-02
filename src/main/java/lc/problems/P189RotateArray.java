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
 * Input: [-1,-100,3,99] and k = 2 Output: [3,99,-1,-100] Explanation: rotate 1
 * steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
 * [3,99,-1,-100] Note:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem. Could you do it in-place with O(1) extra space?
 * 
 * @author zli
 *
 */
public class P189RotateArray {

	// public void rotate(int[] nums, int k) {
	// k = k % nums.length;
	// int count = 0;
	// int tmp;
	// for (int start = 0; count < nums.length; start++) {
	// int current = start;
	// tmp = nums[current];
	// do {
	// int c = nums.length - k + current;
	// int next = c >= nums.length ? c - nums.length : c;
	// nums[current] = nums[next];
	// current = next;
	// count++;
	// } while (current != start);
	// int c = start + k;
	// c = c >= nums.length ? c - nums.length : c;
	// nums[c] = tmp;
	// }
	// }

	public void rotate(int[] nums, int k) {
		final int N = nums.length;

		int i = k % N;

		if (i == 0)
			return;

		int j = 0;
		int num;
		do {
			num = nums[i];
			num[j] = num;
			nums[i] = nums[j];
			j = i;
			i = (j + k) % N;
		} while (i != k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P189RotateArray p = new P189RotateArray();
		int[] input;
		int[] expected;
		expected = new int[] { 5, 6, 7, 1, 2, 3, 4 };
		input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		p.rotate(input, 3);
		System.out.println(Arrays.toString(input));
		Assert.assertArrayEquals(expected, input);

		expected = new int[] { 3, 99, -1, -100 };
		input = new int[] { -1, -100, 3, 99 };
		p.rotate(input, 2);
		Assert.assertArrayEquals(expected, input);

	}
}

//  1, 2, 3, 4
// 
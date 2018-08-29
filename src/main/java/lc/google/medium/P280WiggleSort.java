package lc.google.medium;

import java.util.Arrays;

/**
 * @author zli
 *
 *         Given an unsorted array nums, reorder it in-place such that nums[0]
 *         <= nums[1] >= nums[2] <= nums[3]....
 * 
 *         Example:
 * 
 *         Input: nums = [3,5,2,1,6,4]
 * 
 *         Output: One possible answer is [3,5,1,6,2,4]
 * 
 */
public class P280WiggleSort {

	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		boolean flag = nums[0] < nums[1];

		if (!flag) {
			swap(nums, 0, 1);
			flag = true;
		}

		for (int i = 2; i < nums.length; i++) {
			if ((flag && nums[i - 1] < nums[i]) || (!flag && nums[i - 1] > nums[i]))
				swap(nums, i - 1, i);
			flag = !flag;
		}
	}

	static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		P280WiggleSort p = new P280WiggleSort();
		int[] input = new int[] { 3, 5, 2, 1, 6, 4 };
		p.wiggleSort(input);
		System.out.println(Arrays.toString(input));
		input = new int[] { 2,1 };
		p.wiggleSort(input);
		System.out.println(Arrays.toString(input));
	}

}

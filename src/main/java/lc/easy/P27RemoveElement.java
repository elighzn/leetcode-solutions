package lc.easy;

import java.util.Arrays;

public class P27RemoveElement {
	public int removeElement(int[] nums, int val) {
		int lo = 0, hi = nums.length - 1;

		while (lo <= hi) {
			if (nums[hi] == val)
				hi--;
			else if (nums[lo] == val)
				swap(nums, lo++, hi--);
			else
				lo++;
		}
		return hi + 1;
	}

	private static void swap(int[] nums, int a, int b) {
		if (nums == null || a < 0 || b < 0 || a >= nums.length || b >= nums.length)
			return;
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	public static void main(String[] args) {
		P27RemoveElement p = new P27RemoveElement();

		int[] input = { 3, 3, 0, 3 };

		p.removeElement(input, 3);
		System.out.println(Arrays.toString(input));
	}

}

package zli.leetcode.algrithm.tobesolved;

public class SingleNumber {

	/*
	 * Given an array of integers, every element appears twice except for one. Find
	 * that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */

	public int singleNumber(int[] nums) {
		int result = nums[0];
		for (int i = 0; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleNumber sn = new SingleNumber();
		int[] nums = { 1, 2, 3, 4, 5 };
		for (int n : nums) {
			System.out.println(n);
		}
		int r = sn.singleNumber(nums);
		System.out.println(r);
	}

}

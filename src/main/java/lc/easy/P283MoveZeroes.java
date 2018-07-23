package lc.easy;

import org.junit.Assert;

public class P283MoveZeroes {
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		int firstZero = 0;
		
		for (; firstZero < nums.length; firstZero++) {
			if (nums[firstZero]==0)
				break;
		}
		
		if (firstZero == nums.length)
			return;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0 && i > firstZero) {
				swap(nums, i, firstZero++);
			} 
		}
	}

	static void swap(int[] nums, int i, int j) {
		int swap = nums[i];
		nums[i] = nums[j];
		nums[j] = swap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P283MoveZeroes p = new P283MoveZeroes();
		int[] input = new int[] { 0, 1, 0, 3, 12 };
		p.moveZeroes(input);
		Assert.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, input);

		input = new int[] { 0, 1 };
		p.moveZeroes(input);
		Assert.assertArrayEquals(new int[] { 1, 0 }, input);
		
		input = new int[] { 1, 2 };
		p.moveZeroes(input);
		Assert.assertArrayEquals(new int[] { 1, 2 }, input);
	}

}

package lc.medium;

import org.junit.Assert;

public class P153FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums[nums.length - 1] >= nums[0])
			return nums[0];

		int lo = 0, hi = nums.length - 1;

		while (lo < hi) {
			int m = lo + (hi - lo) / 2;

			if (nums[m] > nums[m + 1])
				return nums[m + 1];

			if (nums[m] > nums[0])
				lo = m + 1;
			else
				hi = m - 1;
		}
		return nums[lo];
	}

	public static void main(String[] args) {
		P153FindMinimumInRotatedSortedArray p = new P153FindMinimumInRotatedSortedArray();
		Assert.assertEquals(1, p.findMin(new int[] { 2, 1 }));
		Assert.assertEquals(1, p.findMin(new int[] { 3, 4, 1, 2 }));
		Assert.assertEquals(1, p.findMin(new int[] { 1, 2, 3, 4 }));
	}

}

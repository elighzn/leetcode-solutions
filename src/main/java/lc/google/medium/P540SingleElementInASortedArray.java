package lc.google.medium;

import org.junit.Assert;

/**
 * @author zli
 * 
 *         Given a sorted array consisting of only integers where every element
 *         appears twice except for one element which appears once. Find this
 *         single element that appears only once.
 * 
 *         Example 1:
 * 
 *         Input: [1,1,2,3,3,4,4,8,8]
 * 
 *         Output: 2
 * 
 *         Example 2:
 * 
 *         Input: [3,3,7,7,10,11,11]
 * 
 *         Output: 10
 * 
 *         Note: Your solution should run in O(log n) time and O(1) space.
 * 
 */
public class P540SingleElementInASortedArray {

	public int singleNonDuplicate(int[] nums) {
		return singleNonDuplicate(nums, 0, nums.length - 1);
	}

	int singleNonDuplicate(int[] nums, int lo, int hi) {
		if (lo == hi)
			return nums[lo];
		int mid = (hi + lo) / 2;
		if (nums[mid] == nums[mid - 1])
			if ((mid - 1 - lo) % 2 == 0)
				return singleNonDuplicate(nums, mid + 1, hi);
			else
				return singleNonDuplicate(nums, lo, mid - 2);
		else if (nums[mid] == nums[mid + 1])
			if ((mid - lo) % 2 == 0)
				return singleNonDuplicate(nums, mid + 2, hi);
			else
				return singleNonDuplicate(nums, lo, mid - 1);
		else
			return nums[mid];
	}

	public static void main(String[] args) {
		P540SingleElementInASortedArray p = new P540SingleElementInASortedArray();
		Assert.assertEquals(4, p.singleNonDuplicate(new int[] { 1, 1, 3, 3, 4, 5, 5, 8, 8 }));
		Assert.assertEquals(2, p.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		Assert.assertEquals(10, p.singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
		Assert.assertEquals(6, p.singleNonDuplicate(new int[] { 1, 1, 3, 3, 4, 4, 6, 8, 8 }));
	}

}

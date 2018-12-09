package lc.coursera.medium;

import org.junit.Assert;

/**
 * @author zhengli
 * 
 *         Your are given an array of positive integers nums.
 * 
 *         Count and print the number of (contiguous) subarrays where the
 *         product of all the elements in the subarray is less than k.
 * 
 *         Example 1:
 * 
 *         Input: nums = [10, 5, 2, 6], k = 100
 * 
 *         Output: 8
 * 
 *         Explanation: The 8 subarrays that have product less than 100 are:
 *         [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * 
 *         Note that [10, 5, 2] is not included as the product of 100 is not
 *         strictly less than k. Note:
 * 
 *         0 < nums.length <= 50000. 0 < nums[i] < 1000. 0 <= k < 10^6.
 */
public class P713SubarrayProductLessThanK {

	public int countNumberOfSubarrayProductLessThanK(int[] nums, int k) {
		if (nums == null || nums.length < 1)
			return 0;

		int ans = 0;
		int[] products = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			products[i] = nums[i];
			if (products[i] < k)
				ans++;
		}

		for (int i = 1; i < nums.length; i++) {
//			System.out.println(Arrays.toString(products));
			boolean allFailed = true;
			for (int j = 0; j + i < nums.length; j++) {
				if (products[j] < k) {
					products[j] *= nums[j + i];
					if (products[j] < k) {
						ans++;
						allFailed = false;
					}
						
				}
			}
			if (allFailed)
				break;
		}

		return ans;
	}

	public static void main(String[] args) {
		P713SubarrayProductLessThanK p = new P713SubarrayProductLessThanK();
		Assert.assertEquals(8, p.countNumberOfSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
	}

}

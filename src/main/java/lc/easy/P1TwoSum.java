package lc.easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class P1TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return null;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			
			Integer in = map.get(nums[i]);
			if (in != null) {
				return new int[] { in, i };
			} else {
				int k = target - nums[i];
				map.put(k, i);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P1TwoSum p = new P1TwoSum();
		Assert.assertArrayEquals(new int[] { 0, 1 }, p.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		Assert.assertArrayEquals(new int[] { 1, 2 }, p.twoSum(new int[] { 3, 2, 4 }, 6));
	}

}

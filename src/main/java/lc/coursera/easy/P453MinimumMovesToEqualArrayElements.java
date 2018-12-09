package lc.coursera.easy;

import java.util.Arrays;

import org.junit.Assert;

/**
 * @author zhengli
 * 
 *         Given a non-empty integer array of size n, find the minimum number of
 *         moves required to make all array elements equal, where a move is
 *         incrementing n - 1 elements by 1.
 * 
 *         Example:
 * 
 *         Input: [1,2,3]
 * 
 *         Output: 3
 * 
 *         Explanation: Only three moves are needed (remember each move
 *         increments two elements):
 * 
 *         [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 */
public class P453MinimumMovesToEqualArrayElements {

	public int getMinimumNumberOfMoves(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		return math(nums);
	}

	public static int math(int[] nums) {
		int ans = 0;

		Arrays.sort(nums); // O(n) = lgN

		// N
		for (int i = 1; i < nums.length; i++) {
			ans += nums[i] - nums[0];
		}

		return ans;
	}

	public static void main(String[] args) {
		P453MinimumMovesToEqualArrayElements p = new P453MinimumMovesToEqualArrayElements();

		Assert.assertEquals(3, p.getMinimumNumberOfMoves(new int[] { 1, 2, 3 }));
	}

}

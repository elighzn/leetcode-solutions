package lc.coursera.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhengli
 * 
 *         Given an array nums of n integers, are there elements a, b, c in nums
 *         such that a + b + c = 0? Find all unique triplets in the array which
 *         gives the sum of zero.
 * 
 *         Note:
 * 
 *         The solution set must not contain duplicate triplets.
 * 
 *         Example:
 * 
 *         Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 *         A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class P15ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		}

		// -4 -1 -1 0 1 2

		Set<List<Integer>> ans = new HashSet<>();
		Arrays.sort(nums); // lgN

		int indexAtZero = Arrays.binarySearch(nums, 0); // lgN

		if (indexAtZero == -1)
			return new ArrayList<>();

		for (int i = 0; i < indexAtZero; i++) {
			for (int j = nums.length - 1; j > indexAtZero; j--) {
				for (int m = i + 1; m < j; m++) {
					if (nums[i]+nums[j]+nums[m]==0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[m]);
						list.add(nums[j]);
						ans.add(list);
					}
				}
			}
		}

		return new ArrayList<>(ans);
	}

	public static void main(String[] args) {

		P15ThreeSum p = new P15ThreeSum();
		System.out.println(p.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}
}

/*
 * solution 1
 * 
 * class Solution { public List<List<Integer>> threeSum(int[] nums) {
 * List<List<Integer>> result = new ArrayList<>(); if (nums == null ||
 * nums.length < 3) return result; Arrays.sort(nums); for (int k = 0; k <
 * nums.length; k++) { if (k > 0 && nums[k] == nums[k - 1]) { continue; } int
 * target = 0 - nums[k]; int i = k + 1; int j = nums.length - 1; while (i < j) {
 * if (nums[i] + nums[j] == target) { result.add(Arrays.asList(nums[k], nums[i],
 * nums[j])); while (i < nums.length - 1 && nums[i + 1] == nums[i]) { i++; }
 * i++; while (j > 0 && nums[j - 1] == nums[j]) { j--; } j--; } else if (nums[i]
 * + nums[j] < target) { i++; } else { j--; } } } return result; } }
 */

/*
 * Solution 2 class Solution {
 *//**
	 * public List<List<Integer>> threeSum(int[] nums) { // 1. filter some cases
	 * if(nums == null || nums.length <=2){ return new ArrayList<List<Integer>>(); }
	 * 
	 * // 2. sort the nums Arrays.sort(nums); int sum = 0; Set<List<Integer>> result
	 * = new HashSet();
	 * 
	 * for(int i = 0 ; i < nums.length - 2; i++){
	 * 
	 * int j = i+1; int k = nums.length - 1;
	 * 
	 * while(j<k){
	 * 
	 * sum = nums[i] + nums[j] + nums[k];
	 * 
	 * if (sum == 0){ ArrayList<Integer> temp = new ArrayList(); temp.add(nums[i]);
	 * temp.add(nums[j]); temp.add(nums[k]); result.add(temp); j++;
	 * 
	 * }else {
	 * 
	 * if(sum<0){ j++; }else{ k--; } } } } return new ArrayList( result);
	 * 
	 * 
	 * }
	 **//*
		 * 
		 * 
		 * // O(N + logN) public static List<List<Integer>> threeSum(int[] nums) {
		 * List<List<Integer>> res = new ArrayList<>();
		 * 
		 * int len = nums.length; if (len < 3) { return res; }
		 * 
		 * Arrays.sort(nums); int lastNeg = Arrays.binarySearch(nums, 0); int firstPos =
		 * lastNeg; int numZero;
		 * 
		 * if (lastNeg < 0) { // no zeros, indices: [0..lastNeg,firstPos..N) numZero =
		 * 0; lastNeg = ((-lastNeg) - 1) - 1; // retrieve insertion point from Java
		 * binarySearch firstPos = lastNeg + 1; // firstPos is immediately after lastNeg
		 * } else { // zeros exist, indices: [0..lastNeg..zeros..firstPos..N)
		 * while(lastNeg > -1 && nums[lastNeg] == 0) lastNeg--; while(firstPos < len &&
		 * nums[firstPos] == 0) firstPos++; numZero = firstPos - lastNeg - 1; }
		 * 
		 * int min = nums[0]; int max = nums[len - 1]; int[] hash = new int[max - min +
		 * 1]; // hash[i] = j means there are j instances of (i + min) for (int v :
		 * nums) { hash[v - min]++; }
		 * 
		 * // Case 0: (0,0,0) if (numZero >= 3) { res.add(Arrays.asList(0, 0, 0)); }
		 * 
		 * // Case 1: (-X,0,X) if (numZero > 0) { for (int i = firstPos; i < len; i++) {
		 * // skip redundant values if(nums[i] == nums[i - 1]) { continue; }
		 * 
		 * int need = 0 - (nums[i] + min); if (need >= 0 && hash[need] > 0) {
		 * res.add(Arrays.asList(0, nums[i], -nums[i])); } } // END for i }
		 * 
		 * // Case 2: 1 positive, 2 negative for (int i = firstPos; i < len; i++) { //
		 * ignore repeated values if (i > firstPos && nums[i] == nums[i - 1]) {
		 * continue; }
		 * 
		 * int half; if (nums[i] % 2 != 0) { // round up half = -(nums[i] + 1) / 2; }
		 * else { // Subcase: (x, -x/2, -x/2) half = -nums[i] / 2; if (half >= min &&
		 * hash[half - min] > 1) { res.add(Arrays.asList(nums[i], half, half)); } }
		 * 
		 * for (int j = lastNeg; j >= 0 && nums[j] > half; j--) { // Note: nums[j] >
		 * half prevents repeated cases. E.g., (4,-1,-3) and (4,-3,-1) // ignore
		 * repeated values if (j < lastNeg && nums[j] == nums[j + 1]) { continue; }
		 * 
		 * int need = 0 - (nums[i] + nums[j]); if (need >= min && hash[need - min] > 0)
		 * res.add(Arrays.asList(nums[i], nums[j], need)); } // END for j } // END for i
		 * 
		 * // Case 3: 1 negative, 2 positive for (int i = lastNeg; i > -1; i--) { if (i
		 * < lastNeg && nums[i] == nums[i + 1]) { continue; }
		 * 
		 * int half; if (nums[i] % 2 != 0) { half = -(nums[i] - 1) / 2; } else { half =
		 * -nums[i] / 2; // Subcase: (x, -x/2, -x/2), x < 0 if(half - min < hash.length
		 * && hash[half - min] > 1) res.add(Arrays.asList(nums[i], half, half)); }
		 * 
		 * for (int j = firstPos; j < len && nums[j] < half; j++) { if (j > firstPos &&
		 * nums[j] == nums[j - 1]) { continue; }
		 * 
		 * int need = 0 - (nums[i] + nums[j]); if (need <= max && hash[need - min] > 0)
		 * { res.add(Arrays.asList(nums[i], nums[j], need)); } } // END for j } // END
		 * for i
		 * 
		 * return res; } }
		 */

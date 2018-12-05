package lc.linkedin.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P47PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {

		if (nums == null || nums.length < 1)
			return new ArrayList<>();

		Set<List<Integer>> ans = new HashSet<>();
		boolean[] used = new boolean[nums.length];
		backtrack(ans, new ArrayList<Integer>(), used, nums);

		return new ArrayList<List<Integer>>(ans);
	}

	void backtrack(Set<List<Integer>> ans, List<Integer> tempList, boolean[] used, int[] nums) {
		if (tempList.size() == nums.length) {
			ans.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])
					continue;
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(ans, tempList, used, nums);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		P47PermutationsII p = new P47PermutationsII();
		System.out.println(p.permuteUnique(new int[] { 1, 1, 2 }));
	}

}

package lc.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		System.out.println(Arrays.toString(candidates) + ":" + target);
		List<List<Integer>> ans = new ArrayList<>();

		int i = candidates.length - 1;
		while (candidates[i] > target)
			i--;
		for (; i >= 0; i--) {
			comboSum(ans, new ArrayList<Integer>(), candidates, i, target, target);
		}
		return ans;
	}

	static void comboSum(List<List<Integer>> ans, List<Integer> an, int[] candidates, int index, int remaining, int target) {
		System.out.println(an + ", index: " + index + ", remaining: " + remaining);
		if (remaining == 0) {
			ans.add(an);
			return;
		} else if (candidates[index] > remaining) {
			if (index == 0)
				return;
			comboSum(ans, an, candidates, index - 1, remaining, target);
		} else if (index >= 0) {
			an.add(candidates[index]);
			comboSum(ans, an, candidates, index, remaining - candidates[index], target);
			if (index > 0)
				comboSum(ans, new ArrayList<>(an), candidates, index - 1, remaining - candidates[index], target);
		}
	}

	public static void main(String[] args) {
		P39CombinationSum p = new P39CombinationSum();
		System.out.println(p.combinationSum(new int[] { 2, 3 }, 7));
	}

}

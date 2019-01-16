package lc.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class P384ShuffleAnArray {

	class Solution {

		int[] original;
		int[] nums;
		List<LinkedList<Integer>> permus = new LinkedList<>();

		public Solution(int[] nums) {
			this.nums = nums;
			original = Arrays.copyOf(nums, nums.length);
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			nums = original;
			return nums;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {

			if (permus.isEmpty()) {
				calPerm(permus, new LinkedList<>(), nums, 0, new boolean[nums.length]);
			}

			int i = new Random().nextInt(permus.size());
			return permus.get(i).stream().mapToInt(a -> a).toArray();
		}

		void calPerm(List<LinkedList<Integer>> ans, LinkedList<Integer> temp, int[] nums, int start, boolean[] used) {
			if (temp.size() == nums.length) {
				ans.add(new LinkedList<>(temp));
				return;
			}

			for (int i = start; i < nums.length; i++) {
				for (int j = 0; j < nums.length; j++) {
					if (used[j])
						continue;

					used[j] = true;
					temp.addLast(nums[j]);
					calPerm(ans, temp, nums, start + 1, used);
					temp.removeLast();
					used[j] = false;
				}
			}
		}
	}

	public void run() {
		Solution s = new Solution(new int[] { 1, 2, 3 });
		System.out.println(Arrays.toString(s.shuffle()));
		System.out.println(Arrays.toString(s.shuffle()));

		System.out.println(Arrays.toString(s.reset()));
	}

	public static void main(String[] args) {
		P384ShuffleAnArray p = new P384ShuffleAnArray();
		p.run();
	}

}

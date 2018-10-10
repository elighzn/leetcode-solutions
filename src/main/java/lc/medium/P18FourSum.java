package lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P18FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		final Set<List<Integer>> ans = new HashSet<>();
		if (nums == null || nums.length < 4)
			return new ArrayList<>();

		Map<Integer, List<int[]>> map = new LinkedHashMap<>();

		for (int i = 0; i < nums.length - 1; i++) {

			for (int j = i + 1; j < nums.length; j++) {

//				System.out.println(i + "-" + j);
				int[] indices = new int[] { i, j };
				int sum = nums[i] + nums[j];

				List<int[]> list = map.get(sum);
				if (list == null) {
					list = new ArrayList<>();
					map.put(sum, list);
				}
				list.add(indices);
			}
		}

		Set<Entry<Integer, List<int[]>>> es = map.entrySet();
		List<Entry<Integer, List<int[]>>> eList = new ArrayList<>(es);

		int lo = 0, hi = eList.size() - 1;
		Set<Integer> set = new HashSet<>();
		while (lo <= hi) {
			Entry<Integer, List<int[]>> e1 = eList.get(lo);
			Entry<Integer, List<int[]>> e2 = eList.get(hi);

			int v1 = e1.getKey();
			int v2 = e2.getKey();
			int sum = v1 + v2;
			if (sum == target) {
				List<int[]> l1 = e1.getValue();
				List<int[]> l2 = e2.getValue();
				set.clear();

				for (int[] i1 : l1) {
					for (int[] i2 : l2) {
						if (i1[0] != i2[0] && i1[0] != i2[1] && i1[1] != i2[0] && i1[1] != i2[1]) {
							Integer[] arr = new Integer[] { nums[i1[0]], nums[i1[1]], nums[i2[0]], nums[i2[1]] };
							Arrays.sort(arr);
							ans.add(Arrays.asList(arr));
						}
					}
				}
				lo++;
				hi--;
			} else if (sum < target)
				lo++;
			else if (sum > target)
				hi--;
		}

		return new ArrayList<>(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P18FourSum p = new P18FourSum();

		// System.out.println(p.fourSum(
		// new int[] { -500, -481, -480, -469, -437, -423, -408, -403, -397, -381, -379,
		// -377, -353, -347, -337,
		// -327, -313, -307, -299, -278, -265, -258, -235, -227, -225, -193, -192, -177,
		// -176, -173, -170,
		// -164, -162, -157, -147, -118, -115, -83, -64, -46, -36, -35, -11, 0, 0, 33,
		// 40, 51, 54, 74, 93,
		// 101, 104, 105, 112, 112, 116, 129, 133, 146, 152, 157, 158, 166, 177, 183,
		// 186, 220, 263, 273,
		// 320, 328, 332, 356, 357, 363, 372, 397, 399, 420, 422, 429, 433, 451, 464,
		// 484, 485, 498, 499 },
		// 2139));
//		System.out.println(p.fourSum(new int[] { -5, 5, 4, -3, 0, 0, 4, -2 }, 8));
//		System.out.println(p.fourSum(new int[] { 0, 0, 0, 0 }, 0));
		System.out.println(p.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
//		System.out.println(p.fourSum(new int[] { -3, -1, 0, 2, 4, 5 }, 2));
	}

}

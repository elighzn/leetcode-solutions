package lc.google.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P387FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		if (s == null || s.length() < 1)
			return -1;

		Map<Character, List<Integer>> map = new HashMap<>();

		char[] cArr = s.toCharArray();
		for (int i = 0; i < cArr.length; i++) {

			List<Integer> indices = map.getOrDefault(cArr[i], new ArrayList<>());

			indices.add(i);
			map.put(cArr[i], indices);
		}
		int min = s.length() - 1;
		for (List<Integer> index : map.values()) {
			if (index.size() == 1) {
				int ind = index.get(0);
				if (min < ind)
					min = ind;
			}
		}
		return min == s.length() - 1 ? -1 : min;
	}

	public static void main(String[] args) {
		P387FirstUniqueCharacterInAString p = new P387FirstUniqueCharacterInAString();
		System.out.println(p.firstUniqChar("leetcode"));
	}

}

package lc.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P451SortCharactersByFrequency {
	public String frequencySort(String s) {
		if (s == null || s.length() < 2)
			return s;

		Map<Character, Integer> mapCount = new HashMap<>();

		char[] sArray = s.toCharArray();
		int maxCount = 0;
		for (Character key : sArray) {
			Integer count = mapCount.getOrDefault(key, 0) + 1;
			mapCount.put(key, count);
			maxCount = Math.max(maxCount, count);
		}

		List<Character>[] array = new List[maxCount + 1];
		
		for (Character key : mapCount.keySet()) {
			int count = mapCount.get(key);
			if (array[count] == null)
				array[count] = new ArrayList<>();
			array[count].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = array.length - 1; i > 0; i--) {
			if (array[i] != null)
				for (Character c : array[i]) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		P451SortCharactersByFrequency p = new P451SortCharactersByFrequency();
		// System.out.println(p.frequencySort("tree"));
		System.out.println(p.frequencySort("treeeAa"));
		
		Set<Integer> set = new HashSet<>();
		
	}

}

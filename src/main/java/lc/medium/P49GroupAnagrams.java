package lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P49GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {

		Map<Set<Character>, List<String>> map = new HashMap<>();
		for (String s : strs) {
			Set<Character> set = new HashSet<>();

			if (s.equals("bob") || s.equals("boo")) {
				System.out.println(s);
			}
			for (char c : s.toCharArray())
				set.add(c);

			List<String> list = map.get(set);
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(s);
			map.put(set, list);
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		P49GroupAnagrams p = new P49GroupAnagrams();
		String[] strs = new String[] { "hos", "boo", "nay", "deb", "wow", "bop", "bob", "brr", "hey", "rye", "eve",
				"elf", "pup", "bum", "iva", "lyx", "yap", "ugh", "hem", "rod", "aha", "nam", "gap", "yea", "doc", "pen",
				"job", "dis", "max", "oho", "jed", "lye", "ram", "pup", "qua", "ugh", "mir", "nap", "deb", "hog", "let",
				"gym", "bye", "lon", "aft", "eel", "sol", "jab" };
		System.out.println(p.groupAnagrams(strs));
	}

}

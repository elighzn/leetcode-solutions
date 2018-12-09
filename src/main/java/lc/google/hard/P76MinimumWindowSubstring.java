package lc.google.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author zli
 * 
 *         Given a string S and a string T, find the minimum window in S which
 *         will contain all the characters in T in complexity O(n).
 * 
 *         Example:
 * 
 *         Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 * 
 *         Note:
 * 
 *         If there is no such window in S that covers all characters in T,
 *         return the empty string "". If there is such window, you are
 *         guaranteed that there will always be only one unique minimum window
 *         in S.
 * 
 *         #Two Pointer, #Hashtable
 * 
 */
public class P76MinimumWindowSubstring {

	public String minWindow(String s, String t) {

		final Set<Character> T = new HashSet<>();
		for (char c : t.toCharArray())
			T.add(c);

		final Map<Character, Integer> countMap = new HashMap<>();

		int lo = 0, hi = 0, minLen = Integer.MAX_VALUE;
		String ans = "";

		final char[] S = s.toCharArray();

		boolean containsAll = false;

		while (hi < S.length) {
			char c = S[hi];
			if (T.contains(c)) {
				int countHi = countMap.getOrDefault(c, 0);
				countMap.put(c, countHi + 1);

				if (!containsAll)
					containsAll = countMap.keySet().containsAll(T);

				while (lo < hi - T.size()) {

					if (T.contains(S[lo])) {
						int countLo = countMap.get(S[lo]);
						if (countLo == 1) {
							int len = hi - lo + 1;
							if (len < minLen) {
								minLen = len;
								ans = s.substring(lo, hi + 1);
							}
							break;
						}
						countMap.put(S[lo], countLo - 1);
					}
					lo++;
				}
			}
			hi++;
		}

		return ans;
	}

	public static void main(String[] args) {
		P76MinimumWindowSubstring p = new P76MinimumWindowSubstring();
		System.out.println(p.minWindow("ab", "a"));
		System.out.println(p.minWindow("a", "a"));
		System.out.println(p.minWindow("ADOBECODEBANC", "ABC"));
	}

}

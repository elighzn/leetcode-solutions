package lc.google.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

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

		if (s == null || t == null || s.length() < t.length())
			return "";

		Map<Character, LinkedList<Integer>> tMap = new HashMap<>();

		for (int i = 0; i < t.length(); i++)
			tMap.put(t.charAt(i), new LinkedList<>());

		for (int i = 0; i < s.length(); i++) {
			LinkedList<Integer> l = tMap.get(s.charAt(i));
			if (l != null)
				l.add(i);
		}
		int lo = -1, hi = s.length();
		for (LinkedList<Integer> list : tMap.values()) {
			if (list.isEmpty())
				return "";

			int first = list.getFirst(), last = list.getLast();

			if (first > lo)
				lo = first;
			if (last < hi)
				hi = last;
		}

		return s.substring(lo, hi);
	}

	public static void main(String[] args) {
		P76MinimumWindowSubstring p = new P76MinimumWindowSubstring();
		Assert.assertEquals("BANC", p.minWindow("ADOBECODEBANC", "ABC"));
	}

}

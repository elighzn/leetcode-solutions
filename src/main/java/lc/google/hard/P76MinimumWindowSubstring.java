package lc.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
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

	// public String minWindow(String s, String t) {
	//
	// if (s == null || t == null || s.length() < t.length())
	// return "";
	//
	// Map<Character, LinkedList<Integer>> tMap = new HashMap<>();
	//
	// for (int i = 0; i < t.length(); i++)
	// tMap.put(t.charAt(i), new LinkedList<>());
	//
	// for (int i = 0; i < s.length(); i++) {
	// LinkedList<Integer> l = tMap.get(s.charAt(i));
	// if (l != null)
	// l.add(i);
	// }
	// int lo = -1, hi = s.length();
	// for (LinkedList<Integer> list : tMap.values()) {
	// if (list.isEmpty())
	// return "";
	//
	// int first = list.getFirst(), last = list.getLast();
	//
	// if (first > lo)
	// lo = first;
	// if (last < hi)
	// hi = last;
	// }
	//
	// return s.substring(lo, hi);
	// }

	public String minWindow(String s, String t) {

		if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length())
			return "";

		int[] ans = new int[2];
		Map<Character, Integer> tMap = new HashMap<>();
		tMap.containsKey('a');

		for (char c : t.toCharArray())
			tMap.put(c, 0);
		int p1 = 0, p2 = 0;
		boolean containAllChars = false;

		int minLength = Integer.MAX_VALUE;

		while (p1 < s.length() || p2 < p1 - t.length() || (p2 == p1) && (p2 == 0)) {

			if (containAllChars) {
				char c = s.charAt(p2);
				Integer ind = tMap.get(c);
				if (ind != null) {
					ind--;
					if (ind == 0) {
						containAllChars = false;
						int length = p1 - p2;
						if (length < minLength) {
							ans[0] = p2;
							ans[1] = p1;
							minLength = length;
						}
						// if (p2 >= p1 - t.length())
						// break;
						// else
						continue;
					}
				}
				p2++;
			} else {
				char c = s.charAt(p1);
				Integer ind = tMap.get(c);
				if (ind != null) {
					tMap.put(c, ++ind);
					containAllChars = foundAll(tMap);
				}
				p1++;
			}
		}
		if (containAllChars) {
			p2 = p2 > 0 ? --p2 : p2;
			int length = p1 - p2;
			if (length < minLength) {
				ans[0] = p2;
				ans[1] = p1;
			}
		}

		return s.substring(ans[0], ans[1]);
	}

	boolean foundAll(Map<Character, Integer> tMap) {
		for (int count : tMap.values())
			if (count == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		P76MinimumWindowSubstring p = new P76MinimumWindowSubstring();
		Assert.assertEquals("a", p.minWindow("ab", "a"));
//		Assert.assertEquals("a", p.minWindow("a", "a"));
//		Assert.assertEquals("BANC", p.minWindow("ADOBECODEBANC", "ABC"));
	}

}

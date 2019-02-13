package lc.google.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zli
 * 
 *         Given a string S and a string T, find the minimum window in S which will contain all the
 *         characters in T in complexity O(n).
 * 
 *         Example:
 * 
 *         Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 * 
 *         Note:
 * 
 *         If there is no such window in S that covers all characters in T, return the empty string
 *         "". If there is such window, you are guaranteed that there will always be only one unique
 *         minimum window in S.
 * 
 *         #Two Pointer, #Hashtable
 * 
 */
public class P76MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int count = t.length(), lo = 0, p = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            Integer n = map.get(s.charAt(i));
            if (n != null && n-- > 0)
                count--;
            if (n != null)
                map.put(s.charAt(i), n);

            while (count == 0) {
                int d = i - lo;
                if (d < len) {
                    len = d;
                    p = lo;
                }
                Integer m = map.get(s.charAt(lo));
                if (m != null && m++ == 0)
                    count++;
                if (m != null)
                    map.put(s.charAt(lo), m);
                lo++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(p, p + len + 1);
    }
    
//    public String minWindow(String s, String t) {
//        int[] map = new int[128];
//        int count = t.length(), lo = 0, len = Integer.MAX_VALUE, p = 0;
//        for (char c : t.toCharArray())
//            map[c]++;
//        for (int i = 0; i < s.length(); i++) {
//            if (map[s.charAt(i)]-- > 0) count--;
//            while (count == 0) {
//                if (i - lo + 1 < len) len = i - (p = lo) + 1;
//                if (map[s.charAt(lo++)]++ == 0) count++;
//            }
//        }
//        return len == Integer.MAX_VALUE ? "" : s.substring(p, p + len);
//    }

    public static void main(String[] args) {
        P76MinimumWindowSubstring p = new P76MinimumWindowSubstring();
        // System.out.println(p.minWindow("ab", "a"));
        // System.out.println(p.minWindow("a", "a"));
        System.out.println(p.minWindow("ADOBECODEBANC", "ABC"));
    }
}

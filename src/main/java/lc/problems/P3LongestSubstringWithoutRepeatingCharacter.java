package lc.problems;

import java.util.HashMap;
import com.google.common.base.Stopwatch;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 * 
 */
public class P3LongestSubstringWithoutRepeatingCharacter {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max = 0;
    int j = 0;
    int N = s.length();
    Integer v = null;
    for (int i = 0; i < N; ++i) {
      char c = s.charAt(i);
      if ((v = map.get(c)) != null)
        j = Math.max(v + 1, j);
      map.put(c, i);
      max = Math.max(max, i - j + 1);
    }
    return max;
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P3LongestSubstringWithoutRepeatingCharacter p =
        new P3LongestSubstringWithoutRepeatingCharacter();
    Stopwatch timer = Stopwatch.createUnstarted();
    timer.start();
    assert p.lengthOfLongestSubstring("abcabcbb") == 3;
    timer.stop();
    System.out.println(timer.elapsed().toNanos());
  }

}

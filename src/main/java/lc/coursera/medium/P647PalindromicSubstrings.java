package lc.coursera.medium;

import java.util.Arrays;

import org.junit.Assert;

/**
 * @author zhengli
 * 
 *         Given a string, your task is to count how many palindromic substrings
 *         in this string.
 * 
 *         The substrings with different start indexes or end indexes are
 *         counted as different substrings even they consist of same characters.
 * 
 *         Example 1:
 * 
 *         Input: "abc"
 * 
 *         Output: 3
 * 
 *         Explanation: Three palindromic strings: "a", "b", "c".
 * 
 *         Example 2:
 * 
 *         Input: "aaa"
 * 
 *         Output: 6
 * 
 *         Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa",
 *         "aaa".
 * 
 * 
 *         Note: The input string length won't exceed 1000.
 */
public class P647PalindromicSubstrings {

	public int countNumberOfPalindramicSubStrings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		char[] cArray = s.toCharArray();

		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = true;
		}

		int ans = s.length();
		for (int i = 1; i < dp.length; i++) {
			boolean allFalse = true;
			for (int j = 0; j < dp[j].length - i; j++) {
				if (dp[i - 1][j]) {
					if (cArray[j] == cArray[j + i]) {
						allFalse = false;
						dp[i][j] = true;
						ans++;
					}
				}
			}
			if (allFalse)
				break;
		}

		return ans;
	}

	public static void main(String[] args) {
		P647PalindromicSubstrings p = new P647PalindromicSubstrings();
		Assert.assertEquals(3, p.countNumberOfPalindramicSubStrings("abc"));
		Assert.assertEquals(6, p.countNumberOfPalindramicSubStrings("aaa"));
	}

}

package lc.hard;

import org.junit.Assert;

public class P10RegularExpressionMatching {

	Result[][] memo;

	public boolean isMatch(String text, String pattern) {

		memo = new Result[text.length() + 1][pattern.length() + 1];

		return dp(0, 0, text, pattern);
	}

	public boolean dp(int i, int j, String text, String pattern) {
		if (memo[i][j] != null)
			return memo[i][j] == Result.TRUE;

		boolean ans;

		if (j == pattern.length()) {
			ans = i == text.length();
		} else {
			boolean isFirstMatch = i < text.length()
					&& (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');

			if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
				
			}
		}
	}

	enum Result {
		TRUE, FALSE
	}

	public static void main(String[] args) {
		P10RegularExpressionMatching p = new P10RegularExpressionMatching();

		Assert.assertEquals(false, p.isMatch("aa", "a"));
		Assert.assertEquals(true, p.isMatch("aa", "a*"));
		Assert.assertEquals(true, p.isMatch("aa", ".*"));
		Assert.assertEquals(true, p.isMatch("aab", "a*b*c*"));
		Assert.assertEquals(false, p.isMatch("mississippi", "mis*is*p*."));
	}

}

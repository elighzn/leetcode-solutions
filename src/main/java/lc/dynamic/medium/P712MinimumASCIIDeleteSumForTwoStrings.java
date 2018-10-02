package lc.dynamic.medium;

import org.junit.Assert;

public class P712MinimumASCIIDeleteSumForTwoStrings {

	public int minimumDeleteSum(String s1, String s2) {

		final int M = s1.length();
		final int N = s2.length();

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		int[][] dp = new int[M + 1][N + 1];

		for (int i = M - 1; i >= 0; i--) {
			dp[i][N] = dp[i + 1][N] + c1[i];
		}
		for (int j = N - 1; j >= 0; j--) {
			dp[M][j] = dp[M][j + 1] + c2[j];
		}

		for (int i = M - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {

				dp[i][j] = c1[i] == c2[j] ? dp[i + 1][j + 1] : Math.min(dp[i + 1][j] + c1[i], dp[i][j + 1] + c2[j]);
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		P712MinimumASCIIDeleteSumForTwoStrings p = new P712MinimumASCIIDeleteSumForTwoStrings();

		Assert.assertEquals(231, p.minimumDeleteSum("sea", "eat"));
		Assert.assertEquals(403, p.minimumDeleteSum("delete", "leet"));
	}

}

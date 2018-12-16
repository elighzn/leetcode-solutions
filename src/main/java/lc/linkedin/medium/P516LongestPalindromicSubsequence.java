package lc.linkedin.medium;

public class P516LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        if (s==null || s.length() <1)
            return 0;
        int ans = 1;
        
        char[] arr = s.toCharArray();
        int[][] dp = new int[arr.length][arr.length];
        
        // s(i,j) represents the inclusive substring of s with index from i to j
        for (int i=0; i< arr.length; i++) {
            dp[i][i] = 1;
        }
        for (int len = 1; len < arr.length; len++) {
            for (int i=0;i<arr.length - len; i++) {
                int j = i+len;
                if (arr[i] == arr[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][arr.length-1];
    }

	public static void main(String[] args) {
		P516LongestPalindromicSubsequence p = new P516LongestPalindromicSubsequence();
		System.out.println(p.longestPalindromeSubseq("bbbab"));
		System.out.println(p.longestPalindromeSubseq("cbbd"));

	}

}

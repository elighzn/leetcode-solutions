package lc.hard;

public class P32LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int ans = 0;
		char[] arr = s.toCharArray();

		int[] dp = new int[arr.length];
		for (int i = 1; i < dp.length; i++) {
			if (arr[i] == ')') {
				if (arr[i - 1] == '(')
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				else if (i - dp[i - 1] > 0 && arr[i - dp[i - 1] - 1] == '(') {
					dp[i] = dp[i - 1] + 2;
					if (i - dp[i - 1] > 2)
						dp[i] += dp[i - dp[i - 1] - 2];
				}

				ans = Math.max(ans, dp[i]);
			}

		}

		return ans;
	}

	public static void main(String[] args) {
		P32LongestValidParentheses p = new P32LongestValidParentheses();

		System.out.println(p.longestValidParentheses("()(())"));

		System.out.println(p.longestValidParentheses("(())())"));

		System.out.println(p.longestValidParentheses("(()"));
		
		String a = "10";
		Integer.valueOf(a);
		Integer.parseInt(a);
	}

}

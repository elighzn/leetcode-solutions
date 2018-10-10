package lc.facebook.medium;

public class P5LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		int[] ans = new int[2];
		char[] arr = new char[s.length() * 2 + 1];
		for (int i = 0; i < s.length(); i++)
			arr[i * 2 + 1] = s.charAt(i);

		boolean[] dp = new boolean[arr.length];
		for (int i = 0; i < dp.length; i++)
			dp[i] = true;

		for (int r = 1; r * 2 < dp.length; r++) {
			boolean hasPalindrome = false;
			for (int i = r; i + r < dp.length; i++) {
				int left = i - r, right = i + r;
				if (dp[i] && arr[left] == arr[right]) {
					hasPalindrome = true;
					ans[0] = left + 1;
					ans[1] = right - 1;

				} else {
					dp[i] = false;
				}
			}
			if (!hasPalindrome)
				break;
		}

		return s.substring((ans[0] - 1) / 2, (ans[1] - 1) / 2 + 1);
	}

	public static void main(String[] args) {
		P5LongestPalindromicSubstring p = new P5LongestPalindromicSubstring();
		System.out.println(p.longestPalindrome("abbc"));
		System.out.println(p.longestPalindrome("abccc"));
	}

}

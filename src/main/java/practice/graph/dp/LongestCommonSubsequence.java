package practice.graph.dp;

public class LongestCommonSubsequence {

	int lcs(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1)
			return 0;

		int N = s1.length() > s2.length() ? s1.length() : s2.length();
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

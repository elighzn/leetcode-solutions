package lc.google.medium;

public class P392IsSubsequence {

	public boolean isSubsequence(String s, String t) {

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		int ps1 = 0, ps2 = sArray.length - 1, pt1 = 0, pt2 = tArray.length - 1;
		while (ps1 <= ps2 && pt1 < pt2) {
			if (tArray[pt1++] == sArray[ps1])
				ps1++;

			if (tArray[pt2--] == sArray[ps2])
				ps2--;
		}
		
		return ps1 > ps2;
	}

	public static void main(String[] args) {
		P392IsSubsequence p = new P392IsSubsequence();
//		System.out.println(p.isSubsequence("abc", "ahbgdc"));
		System.out.println(p.isSubsequence("axc", "ahbgdc"));
	}

}

package lc.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

/**
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address
 * combinations.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 */
public class P93RestoreIPAddresse {

	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.isEmpty())
			return null;

		List<String> ans = new ArrayList<>();

		final int N = s.length();
		String s1, s2, s3, s4;
		for (int a = 1; a < N - 3; a++) {
			if (!isValid(s1 = s.substring(0, a)))
				continue;

			for (int b = a + 1; b < N - 2; b++) {
				if (!isValid(s2 = s.substring(a, b)))
					continue;

				for (int c = b + 1; c < N - 1; c++) {
					if (!isValid(s3 = s.substring(b, c)) || !isValid(s4 = s.substring(c, N)))
						continue;

					String ip = s1 + "." + s2 + "." + s3 + "." + s4;
					ans.add(ip);
				}
			}
		}
		return ans;
	}

	static boolean isValid(String s) {
		if (s.length() > 3)
			return false;
		else {
			int val = Integer.valueOf(s);
			if (val == 0 && s.length() > 1)
				return false;
			else if (val > 255)
				return false;
			else
				return true;
		}
	}

	public static void main(String[] args) {
		P93RestoreIPAddresse p = new P93RestoreIPAddresse();
//		System.out.println(p.restoreIpAddresses("0279245587303"));
		System.out.println(p.restoreIpAddresses("0000"));
	}

}

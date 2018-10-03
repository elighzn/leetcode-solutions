package lc.square.easy;

import org.junit.Assert;

/**
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 */
public class P415AddString {

	private static int DOUBLE_ZERO = '0' + '0';

	public String addStrings(String num1, String num2) {
		if (num1 == null || num2 == null)
			return num1 == null ? num2 : num1;

		if (num1.isEmpty() || num2.isEmpty())
			return num1.isEmpty() ? num2 : num1;

		// make sure num1 is longer
		if (num2.length() > num1.length())
			return add(num2, num1);
		return add(num1, num2);
	}

	static String add(String num1, String num2) {
		StringBuilder sb = new StringBuilder();

		char[] cNum1 = num1.toCharArray();
		char[] cNum2 = num2.toCharArray();

		int i1 = cNum1.length;
		int i2 = cNum2.length;

		boolean carry = false;

		while (i2 > 0) {
			int d = carry ? cNum1[--i1] + cNum2[--i2] + 1 : cNum1[--i1] + cNum2[--i2];
			d -= DOUBLE_ZERO;
			int mod = d - 10;
			carry = mod >= 0 ? true : false;
			cNum1[i1] = (char) (carry ? mod + '0' : d + '0');
		}

		while (carry && i1 > 0) {
			int d = cNum1[--i1] + 1 - '0';
			int mod = d - 10;
			carry = mod >= 0 ? true : false;
			cNum1[i1] = (char) (carry ? mod + '0' : d + '0');
		}

		String ans = String.valueOf(cNum1);
		if (carry)
			ans = "1" + ans;
		return ans;
	}

	public static void main(String[] args) {
		P415AddString p = new P415AddString();
		Assert.assertEquals("413", p.addStrings("408", "5"));

		Assert.assertEquals("10000", p.addStrings("1", "9999"));
		Assert.assertEquals("100012", p.addStrings("12", "100000"));

		Assert.assertEquals("35", p.addStrings("12", "23"));

	}

}

package lc.google.medium;

import org.junit.Assert;

/**
 * @author zli
 *
 *         Given two integers representing the numerator and denominator of a
 *         fraction, return the fraction in string format.
 * 
 *         If the fractional part is repeating, enclose the repeating part in
 *         parentheses.
 * 
 *         Example 1:
 * 
 *         Input: numerator = 1, denominator = 2 Output: "0.5"
 * 
 *         Example 2:
 * 
 *         Input: numerator = 2, denominator = 1 Output: "2"
 * 
 *         Example 3:
 * 
 *         Input: numerator = 2, denominator = 3 Output: "0.(6)"
 * 
 * 
 */
public class P166FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {

		StringBuilder sb = new StringBuilder();

		int n = numerator / denominator;
		sb.append(n);

		numerator -= n * denominator;
		String decimal = "";
		if (numerator > 0) {
			sb.append('.');

			while (numerator > 0) {
				numerator *= 10;
				n = numerator / denominator;
				numerator -= n * denominator;
				decimal += n;
				String rd = getRecurringDecimal(decimal);
				if (rd != null) {
					System.out.println(rd);
				}
			}
			sb.append(decimal);
		}
		return sb.toString();
	}

	String getRecurringDecimal(String str) {
		if (str != null || str.length() > 1) {
			char[] cArray = str.toCharArray();
			for (int l = 1; l < cArray.length / 2; l++) {
				if (isRecurring(cArray, l)) {
					return str.substring(str.length() - l, str.length());
				}
			}
		}
		return null;
	}

	boolean isRecurring(char[] cArray, int l) {
		for (int i = 1; i < l; i++) {
			if (cArray[cArray.length - i] != cArray[cArray.length - l - i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		P166FractionToRecurringDecimal p = new P166FractionToRecurringDecimal();
		// Assert.assertEquals("0.5", p.fractionToDecimal(1, 2));
		// Assert.assertEquals("2", p.fractionToDecimal(2, 1));
		// Assert.assertEquals("0.(6)", p.fractionToDecimal(2, 3));
		Assert.assertEquals("0.(6)", p.fractionToDecimal(1, 6));
	}

}

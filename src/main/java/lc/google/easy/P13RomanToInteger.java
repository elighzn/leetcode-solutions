package lc.google.easy;

import org.junit.Assert;

/**
 * @author zli
 *
 *         Roman numerals are represented by seven different symbols: I, V, X,
 *         L, C, D and M.
 * 
 *         Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000
 * 
 *         For example, two is written as II in Roman numeral, just two one's
 *         added together. Twelve is written as, XII, which is simply X + II.
 *         The number twenty seven is written as XXVII, which is XX + V + II.
 * 
 *         Roman numerals are usually written largest to smallest from left to
 *         right. However, the numeral for four is not IIII. Instead, the number
 *         four is written as IV. Because the one is before the five we subtract
 *         it making four. The same principle applies to the number nine, which
 *         is written as IX. There are six instances where subtraction is used:
 * 
 *         I can be placed before V (5) and X (10) to make 4 and 9. X can be
 *         placed before L (50) and C (100) to make 40 and 90. C can be placed
 *         before D (500) and M (1000) to make 400 and 900.
 * 
 *         Given a roman numeral, convert it to an integer. Input is guaranteed
 *         to be within the range from 1 to 3999.
 * 
 *         Example 1:
 * 
 *         Input: "III" Output: 3
 * 
 *         Example 2:
 * 
 *         Input: "IV" Output: 4
 * 
 *         Example 3:
 * 
 *         Input: "IX" Output: 9
 * 
 *         Example 4:
 * 
 *         Input: "LVIII" Output: 58 Explanation: C = 100, L = 50, XXX = 30 and
 *         III = 3.
 * 
 *         Example 5:
 * 
 *         Input: "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC =
 *         90 and IV = 4.
 * 
 *         I - 1
 * 
 *         V - 5
 * 
 *         X - 10
 * 
 *         L - 50
 * 
 *         C - 100
 * 
 *         D - 500
 * 
 *         M - 1000
 * 
 *         Rules:
 * 
 *         If I comes before V or X, subtract 1 eg: IV = 4 and IX = 9
 * 
 *         If X comes before L or C, subtract 10 eg: XL = 40 and XC = 90
 * 
 *         If C comes before D or M, subtract 100 eg: CD = 400 and CM = 900
 * 
 */
public class P13RomanToInteger {
	final static int I = 1;
	final static int V = 5;
	final static int X = 10;
	final static int L = 50;
	final static int C = 100;
	final static int D = 500;
	final static int M = 1000;

	public int romanToInt(String s) {
		int[] nums = new int[s.length()];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = getRomanNum(s.charAt(i));
		}

		int sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				sum -= nums[i];
			else
				sum += nums[i];
		}
		sum += nums[nums.length - 1];

		return sum;
	}

	int getRomanNum(char c) {
		switch (c) {
		default:
			return I;
		case 'V':
			return V;
		case 'X':
			return X;
		case 'L':
			return L;
		case 'C':
			return C;
		case 'D':
			return D;
		case 'M':
			return M;
		}
	}

	public static void main(String[] args) {
		P13RomanToInteger p = new P13RomanToInteger();

		Assert.assertEquals(3, p.romanToInt("III"));
		Assert.assertEquals(4, p.romanToInt("IV"));
		Assert.assertEquals(9, p.romanToInt("IX"));
		Assert.assertEquals(58, p.romanToInt("LVIII"));
		Assert.assertEquals(1994, p.romanToInt("MCMXCIV"));
	}

}

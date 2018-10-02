package lc.dynamic.medium;
import org.junit.Assert;

/**
 * @author zhengli
 * 
 *         Given a non-negative integer n, count all numbers with unique digits,
 *         x, where 0 ≤ x < 10n.
 * 
 *         Example:
 * 
 *         Input: 2
 * 
 *         Output: 91
 * 
 *         Explanation: The answer should be the total numbers in the range of 0
 *         ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
 */
public class P357CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		
		int total = 0;

		for (int i = 2; i <= n; i++) {
			total += 9 * (10 * (i - 2) + (i - 1) * (int) Math.pow(9, i - 2));
		}
		return (int) Math.pow(10, n) - total;
	}

	public static void main(String[] args) {
		P357CountNumbersWithUniqueDigits p = new P357CountNumbersWithUniqueDigits();
		Assert.assertEquals(1, p.countNumbersWithUniqueDigits(0));
		Assert.assertEquals(10, p.countNumbersWithUniqueDigits(1));
		Assert.assertEquals(91, p.countNumbersWithUniqueDigits(2));
		Assert.assertEquals(739, p.countNumbersWithUniqueDigits(3));
		for (int i = 4; i < 10; i++)
			System.out.println(p.countNumbersWithUniqueDigits(i));
	}

}

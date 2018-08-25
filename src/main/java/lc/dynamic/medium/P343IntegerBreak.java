package lc.dynamic.medium;

import java.util.StringJoiner;

import org.junit.Assert;

/*Given a positive integer n, break it into the sum of at least two positive integers and maximize the 
 * product of those integers. Return the maximum product you can get.
*/

public class P343IntegerBreak {

	public int integerBreak(int n) {
		if (n < 2)
			return 0;

		int last = 0;
		String pre = null;

		for (int i = 2; i <= n; i++) {
			int d = n / i;
			int m = n % i;

			int p = (int) (Math.pow(d + 1, m) * Math.pow(d, i - m));

			if (p <= last) {
				System.out.println(pre);
				break;
			} else {
				last = p;
				pre = a(n, d, m, i, p);
			}
		}
		return last;
	}

	static String a(int number, int d, int m, int n, int p) {
		StringJoiner sj = new StringJoiner("*", number + ": ", "=" + p);
		for (int i = 0; i < m; i++)
			sj.add(String.valueOf(d + 1));
		for (int i = 0; i < n - m; i++)
			sj.add(String.valueOf(d));
		return sj.toString();
	}

	public static void main(String... args) {
		P343IntegerBreak p = new P343IntegerBreak();
		Assert.assertEquals(1, p.integerBreak(2));
		Assert.assertEquals(12, p.integerBreak(7));
		Assert.assertEquals(18, p.integerBreak(8));
		Assert.assertEquals(27, p.integerBreak(9));
		Assert.assertEquals(36, p.integerBreak(10));

		for (int i = 11; i < 50; i++)
			p.integerBreak(i);
	}
}

// 7 = 3+4， 12， 2*2*3， 12
// 8： 4*4 = 16， 3*3*2=18， 2*2*2*2=16，
// 9： 4*5= 20， 3*3*3=27， 2*2*2*3=24
// 10：5*5=25， 3*3*4=36， 2*2*3*3=36， 2*2*2*2*2=32

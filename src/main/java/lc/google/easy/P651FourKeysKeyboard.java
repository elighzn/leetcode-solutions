package lc.google.easy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * @author zli
 *
 *         Imagine you have a special keyboard with the following keys:
 * 
 *         Key 1: (A): Print one 'A' on screen.
 * 
 *         Key 2: (Ctrl-A): Select the whole screen.
 * 
 *         Key 3: (Ctrl-C): Copy selection to buffer.
 * 
 *         Key 4: (Ctrl-V): Print buffer on screen appending it after what has
 *         already been printed.
 * 
 *         Now, you can only press the keyboard for N times (with the above four
 *         keys), find out the maximum numbers of 'A' you can print on screen.
 * 
 *         Example 1:
 * 
 *         Input: N = 3 Output: 3 Explanation: We can at most get 3 A's on
 *         screen by pressing following key sequence: A, A, A
 * 
 *         Example 2:
 * 
 *         Input: N = 7 Output: 9 Explanation: We can at most get 9 A's on
 *         screen by pressing following key sequence: A, A, A, Ctrl A, Ctrl C,
 *         Ctrl V, Ctrl V
 * 
 *         Note:
 * 
 *         1 <= N <= 50 Answers will be in the range of 32-bit signed integer.
 * 
 */
public class P651FourKeysKeyboard {

	public int maxA(int N) {
		int[] best = new int[] { 0, 1, 2, 3, 4, 5, 6, 9, 12, 16, 20, 27, 36, 48, 64, 81 };
		int q = N > 15 ? (N - 11) / 5 : 0;
		return best[N - 5 * q] << 2 * q;
	}

	public static void main(String[] args) {
		P651FourKeysKeyboard p = new P651FourKeysKeyboard();
		// Assert.assertEquals(3, p.maxA(3));
		Assert.assertEquals(9, p.maxA(7));
		Assert.assertEquals(12, p.maxA(8));
		Assert.assertEquals(16, p.maxA(9));

		int[] in = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
				35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
				61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86,
				87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99 };
		int[] expected = { 20, 27, 36, 48, 64, 81, 108, 144, 192, 256, 324, 432, 576, 768, 1024, 1296, 1728, 2304, 3072,
				4096, 5184, 6912, 9216, 12288, 16384, 20736, 27648, 36864, 49152, 65536, 82944, 110592, 147456, 196608,
				262144, 331776, 442368, 589824, 786432, 1048576, 1327104, 1769472, 2359296, 3145728, 4194304, 5308416,
				7077888, 9437184, 12582912, 16777216, 21233664, 28311552, 37748736, 50331648, 67108864, 84934656,
				113246208, 150994944, 201326592, 268435456, 339738624, 452984832, 603979776, 805306368, 1073741824,
				1358954496, 1811939328, 2038431744, 2038431745, 2038431746, 2038431747, 2038431748, 2113929216,
				2113929217, 2113929218, 2113929219, 2113929220, 2113929221, 2113929222, 2113929223, 2113929224,
				2123366400, 2123366401, 2123366402, 2123366403, 2123366404, 2123366405, 2123366406, 2123366407,
				2123366408 };

		for (int i = 0; i < in.length; i++) {
			Assert.assertEquals(expected[i], p.maxA(in[i]));
		}
		System.out.println("Complete.");
	}

}

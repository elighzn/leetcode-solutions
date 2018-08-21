import java.util.Arrays;

import org.junit.Assert;

/**
 * @author zli
 *
 *         You are given n pairs of numbers. In every pair, the first number is
 *         always smaller than the second number.
 * 
 *         Now, we define a pair (c, d) can follow another pair (a, b) if and
 *         only if b < c. Chain of pairs can be formed in this fashion.
 * 
 *         Given a set of pairs, find the length longest chain which can be
 *         formed. You needn't use up all the given pairs. You can select pairs
 *         in any order.
 */
public class P646MaximumLengthOfPairChain {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);


		int ll = 0, val = Integer.MIN_VALUE;
		for (int i = 0; i < pairs.length; i++) {
			if (pairs[i][0] > val) {
				val = pairs[i][1];
				ll++;}
		}

		return ll;
	}

	public static void main(String[] args) {
		P646MaximumLengthOfPairChain p = new P646MaximumLengthOfPairChain();
		Assert.assertEquals(2, p.findLongestChain(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }));

		Assert.assertEquals(2, p.findLongestChain(new int[][] { { 3, 5 }, { 6, 9 }, { 2, 7 }, { 1, 3 }, { 5, 6 } }));
	}

}

package lc.backtracking.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string. Return a list of all possible strings
 * we could create.
 * 
 * Examples:
 * 
 * Input: S = "a1b2"
 * 
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4"
 * 
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * 
 * Output: ["12345"]
 * 
 * Note:
 * 
 * S will be a string with length at most 12. S will consist only of letters or
 * digits.
 */
public class P784LetterCasePermutation {

	public List<String> letterCasePermutation(String S) {
		List<String> ans = new ArrayList<>();
		permute(S.toCharArray(), ans, 0);
		return ans;
	}

	static void permute(final char[] arr, List<String> ans, int index) {
		if (index == arr.length) {
			ans.add(new String(arr));
			return;
		}
		permute(arr, ans, index + 1);

		if (arr[index] >= '0' && arr[index] <= '9')
			return;

		arr[index] ^= (1 << 5);
		permute(arr, ans, index + 1);
		arr[index] ^= (1 << 5);
	}

	public static void main(String[] args) {

		P784LetterCasePermutation p = new P784LetterCasePermutation();

		String[] output1 = new String[] { "a1b2", "a1B2", "A1b2", "A1B2" };
		Assert.assertArrayEquals(output1, p.letterCasePermutation("a1b2").toArray());

		String[] output2 = new String[] { "3z4", "3Z4" };
		Assert.assertArrayEquals(output2, p.letterCasePermutation("3z4").toArray());

		String[] output3 = new String[] { "12345" };
		Assert.assertArrayEquals(output3, p.letterCasePermutation("12345").toArray());
	}

}

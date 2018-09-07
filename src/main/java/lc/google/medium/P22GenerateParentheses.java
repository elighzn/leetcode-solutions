package lc.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

/**
 * @author zli
 *
 *         Given n pairs of parentheses, write a function to generate all
 *         combinations of well-formed parentheses.
 * 
 *         For example, given n = 3, a solution set is:
 * 
 *         [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * 
 */
public class P22GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	public void backtrack(List<String> ans, String str, int open, int close, int max) {
		if (str.length() == max * 2) {
			ans.add(str);
			return;
		}

		if (open < max)
			backtrack(ans, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(ans, str + ")", open, close + 1, max);
	}

	public static void main(String[] args) {
		P22GenerateParentheses p = new P22GenerateParentheses();

		List<String> expected = Arrays.asList(new String[] { "((()))", "(()())", "(())()", "()(())", "()()()" });

		Assert.assertEquals(expected, p.generateParenthesis(3));
	}

}

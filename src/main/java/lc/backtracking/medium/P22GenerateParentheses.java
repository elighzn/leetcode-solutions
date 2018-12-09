package lc.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class P22GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    generateParenthesis(ans, "", 0, 0, n);
    return ans;
  }

  static void generateParenthesis(List<String> ans, String str, int left, int right, int max) {
    if (str.length() == max * 2) {
      ans.add(str);
      return;
    }

    if (left < max) {
      generateParenthesis(ans, str + '(', left + 1, right, max);
    }
    if (left > right) {
      generateParenthesis(ans, str + ')', left, right + 1, max);
    }
  }

  public static void main(String[] args) {
    P22GenerateParentheses p = new P22GenerateParentheses();
    System.out.println(p.generateParenthesis(3));
  }

}

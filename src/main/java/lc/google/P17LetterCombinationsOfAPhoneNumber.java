package lc.google;

import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;

public class P17LetterCombinationsOfAPhoneNumber {

  static private String[] DICT =
      new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "xwyz"};

  public List<String> letterCombinations(String digits) {
    List<String> ans = new LinkedList<>();

    if (digits == null || digits.isEmpty())
      return ans;

    combo(digits.toCharArray(), 0, ans, new char[digits.length()]);

    return ans;
  }

  void combo(char[] arr, int index, List<String> ans, char[] temp) {
    if (index == arr.length) {
      ans.add(new String(temp));
      return;
    }

    int k = arr[index] - '0';
    char[] chars = DICT[k].toCharArray();
    for (char c : chars) {
      temp[index] = c;
      combo(arr, index + 1, ans, temp);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    P17LetterCombinationsOfAPhoneNumber p = new P17LetterCombinationsOfAPhoneNumber();
    Assert.assertArrayEquals(new String[] {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
        p.letterCombinations("23").toArray(new String[0]));
  }

}

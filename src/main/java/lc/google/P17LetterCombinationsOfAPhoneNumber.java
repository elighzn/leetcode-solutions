package lc.google;

import java.util.LinkedList;
import java.util.List;

public class P17LetterCombinationsOfAPhoneNumber {

	private String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "xwyz" };

	public List<String> letterCombinations(String digits) {
		char[] digitss = digits.toCharArray();
		int n = 0;
		if (!digits.isEmpty()) {
			n = 1;
			for (int i = 0; i < digitss.length; i++) {
				n *= map[digitss[i] - '0'].length();
			}
		}

		List<String> combos = new LinkedList<>();

		for (int i = 0; i < digitss.length; i++) {
			char d = digitss[i];
			String mapping = map[d - '0'];

			for (int j = 0; j < mapping.length(); j++) {
				char d2 = mapping.charAt(j);
				System.out.println(d2);
			}

		}

		return combos;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		P17LetterCombinationsOfAPhoneNumber p = new P17LetterCombinationsOfAPhoneNumber();
		System.out.println(p.letterCombinations("23"));

	}

}

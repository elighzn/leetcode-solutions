package lc;

import org.junit.Assert;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA". All letters in this word
 * are not capitals, like "leetcode". Only the first letter in this word is
 * capital if it has more than one letter, like "Google". Otherwise, we define
 * that this word doesn't use capitals in a right way.
 * 
 * Example 1: Input: "USA" Output: True
 * 
 * Example 2: Input: "FlaG" Output: False
 * 
 * @author zhengli
 *
 */
public class P520DetectCapital {

	public boolean detectCapitalUse(String word) {
		if (word.length() > 1) {
			if (Character.isLowerCase(word.charAt(0))) {
				for (int i = 1; i < word.length(); i++)
					if (!Character.isLowerCase(word.charAt(i)))
						return false;
			} else {
				boolean flag = Character.isLowerCase(word.charAt(1));
				int i = 2;
				while (i < word.length()) {
					if (Character.isLowerCase(word.charAt(i++)) != flag)
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		P520DetectCapital p = new P520DetectCapital();
		
		Assert.assertEquals(false, p.detectCapitalUse("mL"));
		Assert.assertEquals(true, p.detectCapitalUse("G"));
		Assert.assertEquals(true, p.detectCapitalUse("FLAG"));
		Assert.assertEquals(true, p.detectCapitalUse("USA"));
		Assert.assertEquals(true, p.detectCapitalUse("leetcode"));
		Assert.assertEquals(true, p.detectCapitalUse("Google"));
		Assert.assertEquals(false, p.detectCapitalUse("FlaG"));

	}

}

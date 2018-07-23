package lc.easy;

import org.junit.Assert;

public class P344ReverseString {
	public String reverseString(String s) {
		if (s == null || s.length() < 2)
			return s;

		char[] c = s.toCharArray();

		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			char swap = c[i];
			c[i++] = c[j];
			c[j--] = swap;
		}
		return String.valueOf(c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P344ReverseString p = new P344ReverseString();
		Assert.assertEquals(new String(), p.reverseString(new String()));
		Assert.assertEquals("olleh", p.reverseString("hello"));
		
	}

}

package lc.coursera.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;

/**
 * @author zhengli
 * 
 *         Given an array of words and a width maxWidth, format the text such
 *         that each line has exactly maxWidth characters and is fully (left and
 *         right) justified.
 * 
 *         You should pack your words in a greedy approach; that is, pack as
 *         many words as you can in each line. Pad extra spaces ' ' when
 *         necessary so that each line has exactly maxWidth characters.
 * 
 *         Extra spaces between words should be distributed as evenly as
 *         possible. If the number of spaces on a line do not divide evenly
 *         between words, the empty slots on the left will be assigned more
 *         spaces than the slots on the right.
 * 
 *         For the last line of text, it should be left justified and no extra
 *         space is inserted between words.
 * 
 *         Note:
 * 
 *         A word is defined as a character sequence consisting of non-space
 *         characters only. Each word's length is guaranteed to be greater than
 *         0 and not exceed maxWidth. The input array words contains at least
 *         one word.
 * 
 * 
 *         Example 1:
 * 
 *         Input:
 * 
 *         words = ["This", "is", "an", "example", "of", "text",
 *         "justification."] maxWidth = 16
 * 
 *         Output: [ "This is an", "example of text", "justification. " ]
 * 
 * 
 *         Example 2:
 * 
 *         Input: words = ["What","must","be","acknowledgment","shall","be"]
 *         maxWidth = 16
 * 
 *         Output: [ "What must be", "acknowledgment ", "shall be " ]
 * 
 *         Explanation: Note that the last line is "shall be " instead of "shall
 *         be", because the last line must be left-justified instead of
 *         fully-justified. Note that the second line is also left-justified
 *         becase it contains only one word.
 * 
 * 
 *         Example 3:
 * 
 *         Input: words =
 *         ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]
 *         maxWidth = 20
 * 
 *         Output: [ "Science is what we", "understand well", "enough to explain
 *         to", "a computer. Art is", "everything else we", "do " ]
 */
public class P68TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ans = new ArrayList<>();
		if (words == null || words.length < 1)
			return ans;
		int len = 0;
		Queue<Integer> indices = new LinkedList<>();

		for (int i = 0; i < words.length; i++) {
			if (len + words[i].length() + indices.size() > maxWidth) {
				ans.add(makeLine(words, indices, maxWidth, len));
				len = 0;
			}
			len += words[i].length();
			indices.add(i);
		}
		ans.add(makeLastLine(words, indices, maxWidth, len));
		return ans;
	}

	String makeLine(String[] words, Queue<Integer> indices, final int maxWidth, final int len) {
		StringBuilder sb = new StringBuilder();
		int numSpaces = maxWidth - len;
		final int N = indices.size() - 1;
		int n1 = N > 0 ? numSpaces / N : numSpaces;
		int n2 = N > 0 ? numSpaces % N : 0;

		while (indices.size() > 1) {
			sb.append(words[indices.poll()]);
			sb.append(getPadding(n1));
			if (n2-- > 0)
				sb.append(' ');
		}
		sb.append(words[indices.poll()]);
		return sb.toString();
	}

	String makeLastLine(String[] words, Queue<Integer> indices, final int maxWidth, final int len) {
		StringBuilder sb = new StringBuilder();
		while (indices.size() > 1) {
			sb.append(words[indices.poll()] + ' ');
		}
		sb.append(words[indices.poll()] + getPadding(maxWidth - len));
		return sb.toString();
	}

	String getPadding(int n) {
		String str = "";
		for (int i = 0; i < n; i++)
			str += ' ';
		return str;
	}

	public static void main(String[] args) {
		P68TextJustification p = new P68TextJustification();
//		print(p.fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16), 16);

		print(p.fullJustify(new String[] { "What", "must", "be", "acknowledgment", "shall", "be" }, 16), 16);

//		print(p.fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to",
//				"explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20), 20);
	}

	public static void print(List<String> strs, int L) {
		for (String s : strs) {
			System.out.println(s);
			Assert.assertEquals(L, s.length());
		}
	}
}

// public class Solution {
// public List<String> fullJustify(String[] words, int L) {
// List<String> res = new ArrayList<String>();
// int index = 0; // [left, right)
// while (index < words.length) {
// int count = words[index].length();
// int right = index + 1;
// while (right < words.length) {
// if (words[right].length() + count + 1 > L) break;
// count += words[right].length() + 1;
// right++;
// }
//
// StringBuilder sb = new StringBuilder();
// int diff = right - index - 1; // 单词与单词之间的大空
// // if last line or number of words in the line is 1, left-justified
// if (right == words.length || diff == 0) {
// for (int i = index; i < right; i++) {
// sb.append(words[i] + " ");
// }
// sb.setLength(sb.length() - 1);
// for (int i = sb.length(); i < L; i++) {
// sb.append(" ");
// }
// } else {
// // middle justified
// int spaces = (L - count) / diff;
// int extra = (L - count) % diff; // [index, index+extra-1] need add 1 more
// for (int i = index; i < right; i++) {
// sb.append(words[i]);
// if (i < right - 1) { // if not last word
// for (int j = 0; j <= (spaces + ((i - index) < extra ? 1 : 0)); j++) {
// sb.append(" ");
// }
// }
// }
// }
// res.add(sb.toString());
// index = right;
// }
// return res;
// }
// }

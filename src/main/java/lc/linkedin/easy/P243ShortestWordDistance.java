package lc.linkedin.easy;

import org.junit.Assert;

//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//Example:
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//Input: word1 = �coding�, word2 = �practice�
//Output: 3
//
//Input: word1 = "makes", word2 = "coding"
//Output: 1
//
//Note:
//You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

public class P243ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length < 2)
			return 0;
		else if (words.length == 2)
			return 1;

		int w1 = -1, w2 = -1, minDist = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				w1 = i;
				if (w2 > -1)
					minDist = Math.min(minDist, Math.abs(w2 - w1));
			} else if (words[i].equals(word2)) {
				w2 = i;
				if (w1 > -1)
					minDist = Math.min(minDist, Math.abs(w2 - w1));
			}
		}

		return minDist < words.length ? minDist : 0;
	}

	public static void main(String[] args) {
		P243ShortestWordDistance p = new P243ShortestWordDistance();
		Assert.assertEquals(3, p.shortestDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
				"coding", "practice"));

		Assert.assertEquals(1, p.shortestDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
				"makes", "coding"));
	}

}

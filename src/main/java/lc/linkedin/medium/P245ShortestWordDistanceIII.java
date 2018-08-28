package lc.linkedin.medium;

import org.junit.Assert;

/**
 * @author sfumato
 *
 *         Given a list of words and two words word1 and word2, return the shortest distance between
 *         these two words in the list.
 * 
 *         word1 and word2 may be the same and they represent two individual words in the list.
 * 
 *         Example: Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * 
 *         Input: word1 = “makes”, word2 = “coding”
 * 
 *         Output: 1
 * 
 *         Input: word1 = "makes", word2 = "makes"
 * 
 *         Output: 3
 * 
 *         Note: You may assume word1 and word2 are both in the list.
 * 
 */
public class P245ShortestWordDistanceIII {

  public int shortestWordDistance(String[] words, String word1, String word2) {
    if (words == null || words.length < 1)
      return 0;

    if (word1.equals(word2))
      return minDist(words, word1);
    else
      return minDist(words, word1, word2);
  }

  int minDist(String[] words, String word1, String word2) {
    final int N = words.length;
    int min = Integer.MAX_VALUE;
    int w1 = -1, w2 = -1;
    for (int i = 0; i < N; i++) {
      String w = words[i];

      if (w.equals(word1)) {
        w1 = i;
        if (w2 > -1)
          min = Math.min(min, w1 - w2);
      }
      if (w.equals(word2)) {
        w2 = i;
        if (w1 > -1)
          min = Math.min(min, w2 - w1);
      }
    }
    return min;
  }

  int minDist(String[] words, String word) {
    final int N = words.length;

    int last = -1;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      if (words[i].equals(word)) {
        if (last > -1)
          min = Math.min(i - last, min);
        last = i;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    P245ShortestWordDistanceIII p = new P245ShortestWordDistanceIII();

    Assert.assertEquals(3, p.shortestWordDistance(
        new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes"));

    Assert.assertEquals(3, p.shortestWordDistance(
        new String[] {"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));

    Assert.assertEquals(1, p.shortestWordDistance(
        new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));

  }

}

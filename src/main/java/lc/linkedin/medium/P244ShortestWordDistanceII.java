package lc.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

/**
 * @author sfumato
 *
 *         Design a class which receives a list of words in the constructor, and implements a method
 *         that takes two words word1 and word2 and return the shortest distance between these two
 *         words in the list. Your method will be called repeatedly many times with different
 *         parameters.
 * 
 * 
 *         Example:
 * 
 *         Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 *         Input: word1 = “coding”, word2 = “practice”
 * 
 *         Output: 3
 * 
 * 
 *         Input: word1 = "makes", word2 = "coding"
 * 
 *         Output: 1
 * 
 *         Note:
 * 
 *         You may assume that word1 does not equal to word2, and word1 and word2 are both in the
 *         list.
 * 
 */
public class P244ShortestWordDistanceII {

  class WordDistance {
    Map<String, Integer> minDists;
    Map<String, List<Integer>> indices;

    public WordDistance(String[] words) {
      final int N = words.length;
      indices = new HashMap<>();
      minDists = new HashMap<>();

      for (int i = 0; i < N; i++) {
        String w = words[i];
        List<Integer> inds = indices.get(w);
        if (inds == null)
          inds = new ArrayList<>();
        inds.add(i);
        indices.put(w, inds);
      }
    }

    public int shortest(String word1, String word2) {

      String key = word1 + "_" + word2;
      Integer m = minDists.get(key);
      if (m != null)
        return m;

      List<Integer> iW1 = indices.get(word1);
      List<Integer> iW2 = indices.get(word2);

      int min = shortest(iW1, iW2);

      minDists.put(key, min);
      return min;
    }

    int shortest(List<Integer> iW1, List<Integer> iW2) {
      int min = Integer.MAX_VALUE;
      int i = 0, j = 0;
      while (i < iW1.size() && j < iW2.size()) {
        int w1 = iW1.get(i);
        int w2 = iW2.get(j);

        if (w2 > w1) {
          min = Math.min(min, w2 - w1);
          i++;
        } else {
          min = Math.min(min, w1 - w2);
          j++;
        }
      }
      return min;
    }
  }

  public void run() {
    String[] s = {"practice", "makes", "perfect", "coding", "makes"};
    WordDistance w = new WordDistance(s);
    Assert.assertEquals(3, w.shortest("coding", "practice"));
    Assert.assertEquals(1, w.shortest("makes", "coding"));
  }

  public static void main(String[] args) {
    P244ShortestWordDistanceII p = new P244ShortestWordDistanceII();
    p.run();
  }

}

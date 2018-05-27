package lc.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    return bfs(beginWord, endWord, wordList);
  }

  private boolean isTransformable(String w1, String w2) {
    if (w1 == null || w2 == null) {
      return false;
    }
    int N = w1.length();
    if (N != w2.length())
      return false;
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (w1.charAt(i) != w2.charAt(i))
        if (++count > 1)
          return false;
    }
    return true;
  }

  private static void addToDistanceMap(Map<Integer, List<String>> distanceToBeginWord, int dist,
      String word) {
    List<String> list = distanceToBeginWord.get(dist);
    if (list == null) {
      list = new ArrayList<>();
    }
    list.add(word);
  }

  private List<List<String>> bfs(String beginWord, String endWord, List<String> wordList) {
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);

    Map<Integer, List<String>> distanceToBeginWord = new LinkedHashMap<>();

    distanceToBeginWord.put(beginWord, 0);

    Set<String> marked = new HashSet<>();
    Map<String, String> edge = new LinkedHashMap<>();

    Iterator<String> itWords;
    String word;

    while (!q.isEmpty()) {
      word = q.poll();
      marked.add(word);
      if (word.equals(endWord))
        break;
      itWords = wordList.iterator();
      while (itWords.hasNext()) {
        String w = itWords.next();
        if (!marked.contains(w))
          if (isTransformable(word, w)) {
            q.add(w);
            marked.add(w);
            distanceToBeginWord.put(w, distanceToBeginWord.get(word) + 1);
            edge.put(w, word);
          }
      }
    }

    System.out.println(edge);

    List<List<String>> paths = new ArrayList<>();
    Integer endWordDist = distanceToBeginWord.get(endWord);
    if (endWordDist != null) {
      for (String w : wordList) {
        Integer dist = distanceToBeginWord.get(w);
        if (dist != null && dist == endWordDist - 1 && this.isTransformable(w, endWord)) {
          List<String> path = new LinkedList<>();
          path.add(endWord);
          path.add(0, w);
          paths.add(path);
        }
      }

      for (List<String> path : paths) {
        String w;
        while ((w = edge.get(path.get(0))) != null) {
          path.add(0, w);
        }
      }
    }
    return paths;
  }

  private List<List<String>> getPathFromDistance(Map<String, Integer> distanceToBeginWord,
      String endWord) {
    List<List<String>> paths = new ArrayList<>();
    String word = endWord;
    Integer dist = distanceToBeginWord.get(word);
    int lastDist;
    Set<Entry<String, Integer>> distanceMapEntrySet = distanceToBeginWord.entrySet();

    while (dist != null && dist > 0) {
      lastDist = dist;
      for (Entry<String, Integer> e : distanceMapEntrySet) {
        dist = lastDist - 1;
        if (dist == e.getValue() && this.isTransformable(e.getKey(), word)) {

        }
      }
    }
    return paths;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<List<String>> paths;

    // paths = s.findLadders("hot", "dog", Arrays.asList(new String[]
    // {"hot","cog","dog","tot","hog","hop","pot","dot"}));
    // System.out.println(paths);
    //
    // paths = s.findLadders("hot", "dog", Arrays.asList(new String[]
    // {"hot","cog","dog","tot","hog","hop","pot","dot"}));
    // System.out.println(paths);

    // paths = s.findLadders("hot", "dot", Arrays.asList(new String[] {"hot", "dot", "dog"}));
    // System.out.println(paths);
    //
    // // [["hot","dot","dog"],["hot","hog","dog"]]
    // paths = s.findLadders("hot", "dog",
    // Arrays.asList(new String[] {"hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"}));
    // System.out.println(paths);

    // [["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
    paths = s.findLadders("red", "tax",
        Arrays.asList(new String[] {"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"}));
    System.out.println(paths);
  }

}

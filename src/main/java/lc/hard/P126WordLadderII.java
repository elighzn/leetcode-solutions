package lc.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest
 * transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each transformed word must exist in the word list. Note
 * that beginWord is not a transformed word. Note:
 * 
 * Return an empty list if there is no such transformation sequence. All words have the same length.
 * All words contain only lowercase alphabetic characters. You may assume no duplicates in the word
 * list. You may assume beginWord and endWord are non-empty and are not the same. Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ] Example 2:
 * 
 * Input: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: []
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class P126WordLadderII {



  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    WordLadder wl = new WordLadder(wordList);
    // System.out.println(wl);

    return bsf(wl, beginWord, endWord);
  }

  List<List<String>> bsf(WordLadder wl, String beginWord, String endWord) {

    wl.addWord(beginWord);

    Map<String, Integer> distance = getDistanceMap(wl, beginWord, endWord);

    List<String>[] dists = getDistanceList(distance, endWord);

    return getALlPathFromDistances(beginWord, endWord, dists);
  }

  Map<String, Integer> getDistanceMap(WordLadder wl, String beginWord, String endWord) {
    Map<String, Boolean> mark = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();

    Queue<String> q = new LinkedList<>();

    q.add(beginWord);
    distance.put(beginWord, 0);

    while (!q.isEmpty()) {
      String word = q.poll();
      mark.put(word, true);
      int newDist = distance.get(word) + 1;
      Iterator<String> it = wl.adjacent(word);
      while (it.hasNext()) {
        String w = it.next();
        if (mark.get(w) == null) {
          distance.put(w, newDist);
          q.add(w);
        }
      }
    }
    return distance;
  }

  List<List<String>> getALlPathFromDistances(String beginWord, String endWord,
      List<String>[] dists) {

    List<List<String>> paths = new ArrayList<>();

    paths.add(new LinkedList<>());
    paths.get(0).add(beginWord);

    for (int d = 1; d < dists.length; d++) {
      List<List<String>> p = new LinkedList<>();
      for (List<String> path : paths) {
        p.addAll(getNextRound(path, dists[d]));
      }
      paths = p;
    }
    return paths;
  }

  List<List<String>> getNextRound(List<String> path, final List<String> nodes) {
    String last = path.get(path.size() - 1);

    List<List<String>> paths = new ArrayList<>();
    for (String v : nodes) {
      if (isTransformable(v, last)) {
        List<String> p = new ArrayList<>(path);
        p.add(v);
        paths.add(p);
      }
    }
    return paths;
  }

  List<String>[] getDistanceList(Map<String, Integer> distance, int maxDistance) {
    List<String>[] dists = new List[maxDistance + 1];

    for (Entry<String, Integer> e : distance.entrySet()) {
      List<String> l = dists[e.getValue()];
      if (l == null) {
        l = new ArrayList<>();
      }
      l.add(e.getKey());
      dists[e.getValue()] = l;
    }
    return dists;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P126WordLadderII p = new P126WordLadderII();

    List<List<String>> solution;

    solution = p.findLadders("red", "tax",
        Arrays.asList(new String[] {"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"}));
    System.out.println(solution);

    solution = p.findLadders("hot", "dog",
        Arrays.asList(new String[] {"hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"}));
    System.out.println(solution);

    // solution = p.findLadders("red", "tax",
    // Arrays.asList(new String[] {"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"}));
    // System.out.println(solution);
    //
    // solution = p.findLadders("red", "tax",
    // Arrays.asList(new String[] {"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"}));
    // System.out.println(solution);

  }

  public class WordLadder {
    private Map<String, Set<String>> transformMap;

    public WordLadder() {
      this.transformMap = new LinkedHashMap<>();
    }

    public WordLadder(String[] words) {
      this.transformMap = new LinkedHashMap<>();
      for (String s : words) {
        addWord(s);
      }
    }

    public WordLadder(List<String> wordList) {
      this.transformMap = new LinkedHashMap<>();
      for (String s : wordList) {
        addWord(s);
      }
    }

    public Iterator<String> adjacent(String word) {
      Set<String> adj = this.transformMap.get(word);
      Iterator<String> it = adj == null ? null : adj.iterator();
      return it;
    }

    public int size() {
      return transformMap.size();
    }

    public Set<String> getWords() {
      return this.transformMap.keySet();
    }

    private void addWord(String word) {
      Set<String> adj = this.transformMap.get(word);
      if (adj == null) {
        adj = new HashSet<String>();
        this.transformMap.put(word, adj);

        transformMap.entrySet().forEach(es -> {
          String key = es.getKey();
          if (!key.equals(word) && isTransformable(key, word)) {
            transformMap.get(key).add(word);
            transformMap.get(word).add(key);
          }
        });
      }
    }

    @Override
    public String toString() {
      return this.transformMap.toString();
    }

  }

  public static boolean isTransformable(String w1, String w2) {
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
}

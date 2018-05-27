package lc.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2 {


  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Map<String, Integer> dictWords = new HashMap<>();
    if (!wordList.contains(beginWord))
      wordList.add(beginWord);
    Graph g = new Graph(wordList.size());
    initGraph(g, wordList, dictWords);
    int s = dictWords.get(beginWord);
    int d = dictWords.get(endWord);
    List<List<Integer>> list = g.getAllPaths(s, d);

    List<List<String>> ladders = new ArrayList<>();
    list.forEach(l->{
      
    });
    return list;
  }

  private void initGraph(Graph g, List<String> wordList, Map<String, Integer> wordIndex) {

    int N = wordList.size();

    Queue<String> q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      String w = wordList.get(i);
      q.add(w);
      wordIndex.put(w, i);
    }

    Iterator<String> it;
    while (!q.isEmpty()) {
      String word = q.poll();
      it = q.iterator();
      int j, i = wordIndex.get(word);
      while (it.hasNext()) {
        String w = it.next();
        if (isTransformable(word, w)) {
          j = wordIndex.get(w);
          g.addEdge(i, j);
          g.addEdge(j, i);
        }
      }
    }
  }

  private static boolean isTransformable(String w1, String w2) {
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

  public static void main(String[] args) {
    Solution2 s = new Solution2();
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

  public class Graph {

    // No. of vertices in graph
    private int v;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    // Constructor
    public Graph(int vertices) {

      // initialise vertex count
      this.v = vertices;

      // initialise adjacency list
      initAdjList();
    }

    // utility method to initialise
    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {
      adjList = new ArrayList[v];

      for (int i = 0; i < v; i++) {
        adjList[i] = new ArrayList<>();
      }
    }

    // add edge from u to v
    public void addEdge(int u, int v) {
      // Add v to u's list.
      adjList[u].add(v);
      // adjList[v].add(u);
    }

    public List<List<Integer>> getAllPaths(int s, int d) {
      boolean[] isVisited = new boolean[v];
      ArrayList<Integer> pathList = new ArrayList<>();

      // add source to path[]
      pathList.add(s);

      List<List<Integer>> list = new ArrayList<>();
      // Call recursive utility
      getAllPathsUtil(list, s, d, isVisited, pathList);

      return list;
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void getAllPathsUtil(List<List<Integer>> list, Integer u, Integer d,
        boolean[] isVisited, List<Integer> localPathList) {

      // Mark the current node
      isVisited[u] = true;

      if (u.equals(d)) {
        list.add(localPathList);
        // System.out.println(localPathList);
      }

      // Recur for all the vertices
      // adjacent to current vertex
      for (Integer i : adjList[u]) {
        if (!isVisited[i]) {
          // store current node
          // in path[]
          localPathList.add(i);
          getAllPathsUtil(list, i, d, isVisited, localPathList);

          // remove current node
          // in path[]
          localPathList.remove(i);
        }
      }

      // Mark the current node
      isVisited[u] = false;
    }
  }
}

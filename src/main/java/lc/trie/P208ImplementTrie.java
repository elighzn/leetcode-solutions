package lc.trie;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sfumato
 *
 *         Implement a trie with insert, search, and startsWith methods.
 * 
 *         Example:
 * 
 *         Trie trie = new Trie();
 * 
 *         trie.insert("apple");
 * 
 *         trie.search("apple"); // returns true
 * 
 *         trie.search("app"); // returns false
 * 
 *         trie.startsWith("app"); // returns true
 * 
 *         trie.insert("app");
 * 
 *         trie.search("app"); // returns true
 * 
 *         Note:
 * 
 *         You may assume that all inputs are consist of lowercase letters a-z.
 * 
 *         All inputs are guaranteed to be non-empty strings.
 */
public class P208ImplementTrie {

  public class Trie {

    Set<Node> initial;

    public void insert(String word) {
      initial = new HashSet<>();
    }

    public boolean search(String word) {
      
      return false;
    }

    public boolean startsWith(String word) {
      
      if (initial.contains(word.indexOf(0)))
      
      
      return false;
    }

    private void a() {
      
    }

  }

  public class Node {
    char value;
    Set<Node> children;

    public Node(char value) {
      this.value = value;
      children = new HashSet<>();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

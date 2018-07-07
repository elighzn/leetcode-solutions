package algorithms.tries;

public class Trie {

  private static final int OFFSET = 97;
  private static final int TRIE_SIZE = 27;
  private static final int WORD_END_INDICATOR_INDEX = TRIE_SIZE - 1;

  private Node root = new Node();

  public void insert(String word) {
    root = insert(root, word, 0);
  }

  private Node insert(Node x, String word, int d) {
    if (x == null) {
      x = new Node();
    }
    if (d == word.length()) {
      if (x.next[WORD_END_INDICATOR_INDEX] == null) {
        x.next[WORD_END_INDICATOR_INDEX] = new Node();
      }
      return x;
    }

    char c = word.charAt(d);
    int i = c - OFFSET;
    x.next[i] = insert(x.next[i], word, d + 1);
    return x;
  }

  public boolean search(String word) {
    return search(root, word, 0);
  }

  private boolean search(Node x, String word, int d) {
    if (x == null)
      return false;
    if (d == word.length())
      return x.next[WORD_END_INDICATOR_INDEX] != null;
    int i = word.charAt(d) - OFFSET;
    return search(x.next[i], word, d + 1);
  }


  public boolean startsWith(String word) {
    return startsWith(root, word, 0);
  }

  private boolean startsWith(Node x, String word, int d) {
    if (x == null)
      return false;
    if (d == word.length())
      return true;
    int i = word.charAt(d) - OFFSET;
    return startsWith(x.next[i], word, d + 1);
  }

  //

  private static class Node {
    private Node[] next = new Node[TRIE_SIZE];

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Trie trie = new Trie();

    trie.insert("apple");
    System.out.println(trie.search("apple")); // returns true
    System.out.println(trie.search("app")); // returns false
    System.out.println(trie.startsWith("app")); // returns true
    trie.insert("app");
    System.out.println(trie.search("app")); // returns true

    System.out.println();

  }

}

package algorithms.tries;

public class Trie {

  private static final int OFFSET = 97;

  private Node root = new Node();

  public void insert(String word) {
    root = insert(root, word, 0);
  }

  private Node insert(Node x, String word, int d) {
    if (x == null)
      return new Node();
    if (d == word.length())
      return x;
    char c = word.charAt(d);
    x.value = c;
    x.next[c - OFFSET] = insert(x, word, d + 1);
    return x;
  }

  // public boolean search(String word);
  //
  // public boolean startWith(String word);
  //
  private static class Node {
    private char value;
    private Node[] next = new Node[27];

    public String toString() {
      return String.valueOf(value);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Trie trie = new Trie();

    trie.insert("apple");
    // trie.search("apple"); // returns true
    // trie.search("app"); // returns false
    // trie.startsWith("app"); // returns true
    // trie.insert("app");
    // trie.search("app"); // returns true

    System.out.println();

  }

}

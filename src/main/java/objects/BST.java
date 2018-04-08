package objects;

public class BST<Key extends Comparable<Key>, Value> {

  private Node root;

  private class Node {
    private Key key;
    private Value val;
    private Node left, right;
    private int n;

    public Node(Key key, Value val, int n) {
      this.key = key;
      this.val = val;
      this.n = n;
    }
  }
}

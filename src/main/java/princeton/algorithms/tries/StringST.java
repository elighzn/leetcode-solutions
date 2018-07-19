package princeton.algorithms.tries;

public class StringST<Value> {

  private static final int R = 256;
  private Node root = new Node();
  
  public void put(String key, String value) {
    root = put(root, key, value, 0);
  }

  private Node put(Node x, String key, String value, int d) {
    if (x == null)
      x = new Node();
    if (d == key.length()) {
      x.value = value;
      return x;
    }
    char c = key.charAt(d);
    x.next[c] = put(x.next[c], key, value, d + 1);
    return x;
  }

  public Value get(String key) {
    Node x = get(root, key, 0);
    if (x == null)
      return null;
    return (Value) x.value;
  }

  private Node get(Node x, String key, int d) {
    if (x == null)
      return null;
    if (d == key.length())
      return x;
    char c = key.charAt(d);
    return get(x.next[c], key, d + 1);
  }

  void delete(String key) {
    Node x = get(root, key, 0);
    if (x != null) {
      x = null;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    StringST st = new StringST();

    st.put("word", "bit");
    st.put("word", "ace");
    
    Object obj = st.get("word");
    
    System.out.println(Character.getNumericValue('a'));
    
    char c = 10;
    System.out.println(Integer.valueOf('a'));
    
    
  }

  private static class Node {
    private Object value;
    private Node[] next = new Node[R];
  }

}

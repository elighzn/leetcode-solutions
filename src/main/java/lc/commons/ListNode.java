package lc.commons;

import java.util.StringJoiner;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public String toString() {
    return String.valueOf(val);
  }

  public String getListAsString() {
    StringJoiner sj = new StringJoiner(", ", "[", "]");
    sj.add(this.toString());
    ListNode node = next;
    while (node != null) {
      sj.add(node.toString());
      node = node.next;
    }
    return sj.toString();
  }

  public static ListNode convertIntegerAsListNode(int x) {
    ListNode root = new ListNode(x % 10);
    x /= 10;
    if (x > 0) {
      ListNode top = new ListNode(x % 10);
      root.next = top;
      x /= 10;
      while (x > 0) {
        top.next = new ListNode(x % 10);
        top = top.next;
        x /= 10;
      }
    }
    return root;
  }

  public static void main(String[] args) {
    ListNode node = ListNode.convertIntegerAsListNode(123);
    System.out.println(node.getListAsString());
  }
}

package lc.medium;

import lc.commons.ListNode;

public class P2AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int sum = 0;
    int carry = 0;
    ListNode root = new ListNode(0);
    ListNode node = root;

    while (l1 != null || l2 != null) {
      sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
      carry = sum / 10;
      if (carry > 0)
        sum %= 10;

      node.next = new ListNode(sum);
      node = node.next;
      if (l1 != null)
        l1 = l1.next;
      if (l2 != null)
        l2 = l2.next;
    }

    if (carry > 0) {
      node.next = new ListNode(1);
    }

    return root.next;
  }
  // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  // if (l1 == null || l2 == null) {
  // return l1 == null ? l2 : l1;
  // }
  //
  // return addTwo(l1, l2);
  // }
  //
  // static ListNode addTwo(ListNode l1, ListNode l2) {
  // if (l1 == null || l2 == null) {
  // return l1 == null ? l2 : l1;
  // }
  //
  // int val = l1.val + l2.val;
  // ListNode node = new ListNode(val);
  // node.next = addTwo(l1.next, l2.next);
  // if (val >= 10) {
  // node.val = val % 10;
  // node.next = addTwo(node.next, new ListNode(1));
  // }
  // return node;
  // }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P2AddTwoNumbers p = new P2AddTwoNumbers();
    System.out.println(p
        .addTwoNumbers(ListNode.convertIntegerAsListNode(50), ListNode.convertIntegerAsListNode(50))
        .getListAsString());
    System.out.println(
        p.addTwoNumbers(ListNode.convertIntegerAsListNode(5), ListNode.convertIntegerAsListNode(5))
            .getListAsString());
    System.out.println(p.addTwoNumbers(ListNode.convertIntegerAsListNode(342),
        ListNode.convertIntegerAsListNode(465)).getListAsString());
    System.out.println(
        p.addTwoNumbers(ListNode.convertIntegerAsListNode(18), ListNode.convertIntegerAsListNode(0))
            .getListAsString());
    System.out
        .println(p.addTwoNumbers(ListNode.convertIntegerAsListNode(5), null).getListAsString());
    System.out
        .println(p.addTwoNumbers(null, ListNode.convertIntegerAsListNode(5)).getListAsString());

  }

}

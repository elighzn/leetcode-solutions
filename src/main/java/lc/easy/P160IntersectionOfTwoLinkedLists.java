package lc.easy;

import lc.commons.ListNode;
import lc.commons.ListNodeUtils;

public class P160IntersectionOfTwoLinkedLists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode p1 = headA, p2 = headB;

    while (p1 != p2) {
      System.out.println("p1: " + ListNodeUtils.listNodeToString(p1));
      System.out.println("p2: " + ListNodeUtils.listNodeToString(p2));

      if (p1 == null)
        p1 = headB;
      else
        p1 = p1.next;

      if (p2 == null)
        p2 = headA;
      else
        p2 = p2.next;

    }
    return p1;
  }

  public static void main(String[] args) {
    P160IntersectionOfTwoLinkedLists p = new P160IntersectionOfTwoLinkedLists();
    System.out.println(ListNodeUtils.listNodeToString(p.getIntersectionNode(
        ListNodeUtils.stringToListNode("[2,6,4]"), ListNodeUtils.stringToListNode("[1,5]"))));
  }

}

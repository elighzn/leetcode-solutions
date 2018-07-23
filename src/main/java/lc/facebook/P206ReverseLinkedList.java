package lc.facebook;

import lc.collections.ListNode;
import lc.collections.SinglyLinkedList;

/*Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?*/
public class P206ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// head = iterativeReverse(head);
		ListNode last = head;
		head = resursiveReverse(head);
		last.next = null;
		return head;
	}

	private ListNode iterativeReverse(ListNode node) {
		ListNode previous = null;
		ListNode next = node.next;
		node.next = previous;
		do {
			previous = node;
			node = next;
			next = node.next;
			node.next = previous;
		} while (next != null);

		return node;
	}

	private ListNode resursiveReverse(ListNode node) {
		
		ListNode next = node.next;
		ListNode head;
		if (next == null) {
			return node;
		} else
			head = resursiveReverse(next);
		next.next = node;
		return head;
	}

	public void run(int[] input) {

		SinglyLinkedList ll = new SinglyLinkedList();
		for (int i : input) {
			ll.add(i);
		}
		ListNode node = ll.getHead();
		System.out.println(node.getListAsString());
		node = reverseList(node);
		System.out.println(node.getListAsString());
	}

	public static void main(String[] args) {
		P206ReverseLinkedList p = new P206ReverseLinkedList();
		p.run(new int[] {});
		p.run(new int[] { 1, 3, 5, 6, 7, 2, 3 });

	}
}

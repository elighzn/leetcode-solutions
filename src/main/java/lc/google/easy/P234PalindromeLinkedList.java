package lc.google.easy;

import java.util.LinkedList;

import org.junit.Assert;

import lc.commons.ListNode;

public class P234PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		ListNode fast = head, slow = head;

		while (head.next != null && head.next.next != null) {
			head = head.next.next;
			slow = slow.next;
		}

		if (fast != null)
			slow = slow.next;

		slow = reverse(slow);

		while (slow != null) {
			if (head.val != slow.val)
				return false;
			head = head.next;
			slow = slow.next;
		}
		return true;
	}

	ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}

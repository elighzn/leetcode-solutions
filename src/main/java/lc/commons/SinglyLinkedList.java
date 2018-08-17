package lc.commons;

public class SinglyLinkedList {
	ListNode head;
	ListNode tail;

	public SinglyLinkedList() {
		head = null;
	}

	public void add(int x) {
		if (head == null)
			head = new ListNode(x);
		else if (tail == null) {
			tail = new ListNode(x);
			head.next = tail;
		} else {
			tail.next = new ListNode(x);
			tail = tail.next;
		}
	}

	public ListNode getHead() {
		return head;
	}

	public String toString() {
		return head.getListAsString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList ll = new SinglyLinkedList();
		int[] input = new int[] { 1, 3, 5, 6, 7, 2, 3 };
		for (int i : input) {
			ll.add(i);
		}
	}

}

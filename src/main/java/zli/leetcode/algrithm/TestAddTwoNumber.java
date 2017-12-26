package zli.leetcode.algrithm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAddTwoNumber {

	ListNode ln1;
	ListNode ln2;
	AddTwoNumbers add = new AddTwoNumbers();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ln1 = new ListNode(2);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(3);

		ln2 = new ListNode(5);
		ln2.next = new ListNode(6);
		ln2.next.next = new ListNode(4);

		System.out.printf("ListNodes: %s, %s\n", ln1.toString(), ln2.toString());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ListNode sum = add.addTwoNumbers(ln1, ln2);
		System.out.printf("Sum: %s\n", sum.toString());
	}

	public class AddTwoNumbers {

		/**
		 * You are given two non-empty linked lists representing two
		 * non-negative integers. The digits are stored in reverse order and
		 * each of their nodes contain a single digit. Add the two numbers and
		 * return it as a linked list.
		 * 
		 * You may assume the two numbers do not contain any leading zero,
		 * except the number 0 itself. *
		 * 
		 * Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
		 * Explanation: 342 + 465 = 807.
		 */

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			return addTwoNode(l1, l2, 0);
		}

		private ListNode addTwoNode(ListNode l1, ListNode l2, int lastCarry) {
			int sum = l1.val + l2.val + lastCarry;
			int carry = (int) sum / 10;
			int remainder = sum % 10;

			ListNode ln = new ListNode(remainder);
			if (l1.next != null && l2.next != null) {
				ln.next = addTwoNode(l1.next, l2.next, carry);
			} else if (l1.next != null) {
				ln.next = addTwoNode(l1.next, new ListNode(carry), 0);
			} else if (l2.next != null) {
				ln.next = addTwoNode(l2.next, new ListNode(carry), 0);
			} else if (carry > 0) {
				ln.next = addTwoNode(new ListNode(carry), new ListNode(0), 0);
			} else {
				ln.next = null;
			}

			return ln;
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public String toString() {

			ListNode ln = this;
			String str = String.valueOf(ln.val);
			while (ln.next != null) {
				ln = ln.next;
				str += ln.val;
			}
			return str;
		}
	}
}

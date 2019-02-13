package lc.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import lc.commons.ListNode;

public class P23MergeKSortedLists {
	static class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			return mergeLists(lists, 0, lists.length - 1);
		}

		ListNode mergeLists(ListNode[] lists, int lo, int hi) {
			if (lo >= hi)
				return lists[lo];

			int mid = lo + (hi - lo) / 2;
			ListNode l1 = mergeLists(lists, lo, mid);
			ListNode l2 = mergeLists(lists, mid + 1, hi);
			return merge(l1, l2);
		}

		ListNode merge(ListNode a, ListNode b) {
			if (a == null)
				return b;
			if (b == null)
				return a;

			if (a.val < b.val) {
				a.next = merge(a.next, b);
				return a;
			} else {
				b.next = merge(a, b.next);
				return b;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

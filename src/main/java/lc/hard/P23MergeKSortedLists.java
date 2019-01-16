package lc.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import lc.commons.ListNode;

public class P23MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});
		
		boolean flag = allEnd(lists);
		
		while (!allEnd(lists)) 
	}
	
	boolean allEnd(ListNode[] lists) {
		for (ListNode node : lists)
			if (node.next != null)
				return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package lc.collections;

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
}

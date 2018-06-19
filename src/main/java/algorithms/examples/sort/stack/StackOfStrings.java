package algorithms.examples.sort.stack;

import algorithms.examples.utils.StdIn;
import algorithms.examples.utils.StdOut;

public class StackOfStrings {

	private Node first = null;

	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}

	public String pop() {
		String item = null;
		if (!isEmpty()) {
			item = first.item;
			first = first.next;
		}
		return item;
	}

	boolean isEmpty() {
		return first == null;
	}

	private class Node {
		String item;
		Node next;
	}

	public static void main(String[] args) {
		
		StackOfStrings stack = new StackOfStrings();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if ("-".equals(s)) {
				StdOut.print(stack.pop());
			} else {
				stack.push(s);
			}
		}
	}
}

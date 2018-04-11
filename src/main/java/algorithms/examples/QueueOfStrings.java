package algorithms.examples;

public class QueueOfStrings {
	private Node first;
	private Node last;

	void enqueue(String item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
	}

	String dequeue() {
		String item = null;
		if (!isEmpty()) {
			item = first.item;
			first = first.next;
			if (isEmpty()) {
				last = null;
			}
		}
		return item;
	}

	boolean isEmpty() {
		return first == null;
	}

	int size() {
		int n = 0;
		Node current = first;
		while (current != null) {
			n++;
			current = first.next;
		}
		return n;
	}

	private class Node {
		String item;
		Node next;
	}

	public static void main(String[] args) {

		QueueOfStrings queue = new QueueOfStrings();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if ("-".equals(s)) {
				StdOut.print(queue.dequeue());
			} else {
				queue.enqueue(s);
			}
		}
	}
}

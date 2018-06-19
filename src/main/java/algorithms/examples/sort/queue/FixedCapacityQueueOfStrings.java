package algorithms.examples.sort.queue;

import algorithms.examples.utils.StdIn;
import algorithms.examples.utils.StdOut;

public class FixedCapacityQueueOfStrings {

	private String[] q;
	private int head = 0;
	private int tail = 0;

	public FixedCapacityQueueOfStrings(int capacity) {
		q = new String[capacity];
	}

	void enqueue(String item) {
		if (tail < q.length) {
			q[tail++] = item;
		}
	}

	String dequeue() {
		String item = null;
		if (!isEmpty()) {
			item = q[head++];
		}
		return item;
	}

	boolean isEmpty() {
		return head == tail;
	}

	int size() {
		return tail-head;
	}

	public static void main(String[] args) {

		FixedCapacityQueueOfStrings queue = new FixedCapacityQueueOfStrings(10);
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if ("-".equals(s)) {
				StdOut.println(queue.dequeue());
			} else {
				queue.enqueue(s);
			}
		}
	}
}

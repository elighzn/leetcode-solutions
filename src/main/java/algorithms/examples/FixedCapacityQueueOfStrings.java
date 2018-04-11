package algorithms.examples;

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
		return head < tail;
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

	public static void main(String[] args) {

		FixedCapacityQueueOfStrings stack = new FixedCapacityQueueOfStrings(10);
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

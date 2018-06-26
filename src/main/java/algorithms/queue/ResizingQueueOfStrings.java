package algorithms.queue;

import algorithms.utils.StdIn;
import algorithms.utils.StdOut;

public class ResizingQueueOfStrings {

	private String[] q;
	private int head = 0;
	private int tail = 0;

	public ResizingQueueOfStrings() {
		q = new String[1];
	}

	public void enqueue(String item) {
		if (tail >= q.length) {
			resize(q.length * 2);
		}
		q[tail++] = item;
	}

	public String dequeue() {
		String item = null;
		if (!isEmpty()) {
			item = q[head++];
		}
		int N = size();
		if (N > 0 && N == q.length / 4) {
			resize(q.length / 2);
		}

		return item;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public int size() {
		return tail - head;
	}

	private void resize(int capacity) {
		int N = size();
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = q[i + head];
		}

		q = copy;
		head = 0;
		tail = head + N;
	}

	public static void main(String[] args) {

		ResizingQueueOfStrings queue = new ResizingQueueOfStrings();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if ("-".equals(s)) {
				StdOut.println(queue.dequeue());
			} else {
				queue.enqueue(s);
			}
			System.out.println(String.format("size: %d, head: %d, tail: %d", queue.size(), queue.head, queue.tail));
		}
	}
}

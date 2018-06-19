package algorithms.examples.sort.stack;

import algorithms.examples.utils.StdIn;
import algorithms.examples.utils.StdOut;

public class FixedCapacityStackOfStrings {

	private String[] s;
	private int N = 0;

	public FixedCapacityStackOfStrings(int capacity) {
		this.s = new String[capacity];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(String item) {
		s[N++] = item;
	}

	public String pop() {
		// avoid loitering
		String item = s[--N];
		s[N] = null;
		return item;
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

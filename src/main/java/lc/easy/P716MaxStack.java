package lc.easy;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;

public class P716MaxStack {
	class MaxStack {
		TreeMap<Integer, Integer> max;
		LinkedList<Integer> stack;

		/** initialize your data structure here. */
		public MaxStack() {
			max = new TreeMap<>();
			stack = new LinkedList<>();
		}

		public void push(int x) {
			stack.add(x);
			max.put(x, max.getOrDefault(x, 0) + 1);
		}

		public int pop() {
			int e = stack.pop();
			if (e == max.lastKey()) {
				Map.Entry<Integer, Integer> lastEntry = max.pollLastEntry();
				int v = lastEntry.getValue() - 1;
				if (v > 0)
					max.put(e, v);
			}
			return e;
		}

		public int top() {
			return stack.getLast();
		}

		public int peekMax() {
			return max.lastKey();
		}

		public int popMax() {
			Map.Entry<Integer, Integer> lastEntry = max.lastEntry();
			int e = lastEntry.getKey(), v = lastEntry.getValue();
			if (v > 1)
				max.put(e, v - 1);

			stack.removeLastOccurrence(e);
			return e;
		}

	}

	public void run() {
		MaxStack p = new MaxStack();
		p.push(5);
		p.push(1);
		p.push(5);
		Assert.assertEquals(5, p.top());
		Assert.assertEquals(5, p.popMax());
		Assert.assertEquals(1, p.top());
		Assert.assertEquals(5, p.peekMax());
		Assert.assertEquals(1, p.pop());
		Assert.assertEquals(5, p.top());
	}

	public static void main(String[] args) {
		P716MaxStack p = new P716MaxStack();
		p.run();

	}

}

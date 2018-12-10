package lc.linkedin.easy;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class P716MaxStack {

	class MaxStack {

		TreeMap<Integer, Integer> stack;
		PriorityQueue<Integer> max;

		/** initialize your data structure here. */
		public MaxStack() {
			stack = new TreeMap<>();
			max = new PriorityQueue<Integer>((a, b)-> -Integer.compare(a, b));
		}

		// log(n)
		public void push(Integer x) {
			// O(n) = 1
			max.offer(x);
			// O(n) = log(n)
			stack.put(x, stack.getOrDefault(x, 0) + 1);
		}

		// O(n) = log(n);
		public int pop() {
			Map.Entry<Integer, Integer> e = stack.lastEntry();
			int k = e.getKey(), q = e.getValue() - 1;
			if (q > 0)
				stack.put(k, q);
			else
				stack.remove(k);

			max.remove(k);
			return k;
		}

		// O(n) = 1
		public int top() {
			return stack.lastKey();
		}

		// 1
		public int peekMax() {
			return max.peek();
		}

		// 1
		public int popMax() {
			int k = max.poll();
			int q = stack.get(k);
			if (q > 0)
				stack.put(k, q);
			else
				stack.remove(k);
			return k;
		}
	}

	public void run() {
		MaxStack ms = new MaxStack();
		ms.push(1);
		ms.push(1);
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(1);
		ms.push(5);
		ms.push(11);
		ms.push(6);
		System.out.println(ms.max);
		System.out.println(ms.top());
		System.out.println(ms.popMax());
		System.out.println(ms.top());
		System.out.println(ms.peekMax());
		System.out.println(ms.pop());
		System.out.println(ms.top());
	}

	public static void main(String[] args) {
		P716MaxStack p = new P716MaxStack();
		p.run();
	}

}

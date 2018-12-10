package lc.google.easy;

import java.util.LinkedList;
import java.util.Queue;

public class P933NumberOfRecentCalls {

	class RecentCounter {
		Queue<Integer> q = new LinkedList<>();

		public RecentCounter() {
		}

		public int ping(int t) {
			int threshold = t - 3000;

			while (!q.isEmpty() && q.peek() < threshold) {
				q.poll();
			}
			q.add(t);
			return q.size();
		}
	}

	void run() {
		RecentCounter r = new RecentCounter();
		System.out.println(r.ping(1));
		System.out.println(r.ping(100));
		System.out.println(r.ping(3001));
		System.out.println(r.ping(3002));
	}

	public static void main(String[] args) {
		P933NumberOfRecentCalls p = new P933NumberOfRecentCalls();
		p.run();
	}

}

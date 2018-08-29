package lc.google.medium;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Assert;

/**
 * @author zli
 *
 *         Design a hit counter which counts the number of hits received in the
 *         past 5 minutes.
 * 
 *         Each function accepts a timestamp parameter (in seconds granularity)
 *         and you may assume that calls are being made to the system in
 *         chronological order (ie, the timestamp is monotonically increasing).
 *         You may assume that the earliest timestamp starts at 1.
 * 
 *         It is possible that several hits arrive roughly at the same time.
 * 
 *         Example:
 * 
 *         HitCounter counter = new HitCounter();
 * 
 *         // hit at timestamp 1. counter.hit(1);
 * 
 *         // hit at timestamp 2. counter.hit(2);
 * 
 *         // hit at timestamp 3. counter.hit(3);
 * 
 *         // get hits at timestamp 4, should return 3. counter.getHits(4);
 * 
 *         // hit at timestamp 300. counter.hit(300);
 * 
 *         // get hits at timestamp 300, should return 4. counter.getHits(300);
 * 
 *         // get hits at timestamp 301, should return 3. counter.getHits(301);
 * 
 *         Follow up: What if the number of hits per second could be very large?
 *         Does your design scale?
 * 
 */
public class P362DesignHitCounter {

	class HitCounter {
		int recentTS = 0;
		Integer count;
		Map<Integer, Integer> counterMap = new LinkedHashMap<>();

		/** Initialize your data structure here. */
		public HitCounter() {
		}

		/**
		 * Record a hit.
		 * 
		 * @param timestamp
		 *            - The current timestamp (in seconds granularity).
		 */
		public void hit(int timestamp) {
			if (timestamp != recentTS) {
				count = new Integer(0);
				recentTS = timestamp;
			}
			count++;
			counterMap.put(timestamp, count);

		}

		/**
		 * Return the number of hits in the past 5 minutes.
		 * 
		 * @param timestamp
		 *            - The current timestamp (in seconds granularity).
		 */
		public int getHits(int timestamp) {

			int startTS = timestamp - 300;
			int totalHits = counterMap.entrySet().stream().filter(e -> e.getKey() > startTS).mapToInt(e -> e.getValue())
					.sum();
			return totalHits;
		}
	}

	void run1() {
		HitCounter counter = new HitCounter();
		counter.hit(1);
		counter.hit(2);
		counter.hit(3);
		// Assert.assertEquals(3, counter.getHits(4));
		counter.hit(300);
		Assert.assertEquals(4, counter.getHits(300));
		Assert.assertEquals(3, counter.getHits(301));
	}

	void run2() {
		HitCounter counter = new HitCounter();
		counter.hit(1);
		counter.hit(1);
		counter.hit(1);
		counter.hit(1);
		Assert.assertEquals(4, counter.getHits(300));
	}

	/**
	 * Your HitCounter object will be instantiated and called as such: HitCounter
	 * obj = new HitCounter(); obj.hit(timestamp); int param_2 =
	 * obj.getHits(timestamp);
	 */

	public static void main(String[] args) {
		P362DesignHitCounter p = new P362DesignHitCounter();
		// p.run2();
		p.run1();
	}

}

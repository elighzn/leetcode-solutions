package lc.google.hard;

import java.util.TreeSet;

public class P683KEmptySlots {
	public int kEmptySlots(int[] flowers, int k) {
		int[] days = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++) {
			days[flowers[i] - 1] = i + 1;
		}

		int ans = Integer.MAX_VALUE;
		int left = 0, right = k + 1;

		search: while (right < days.length) {
			for (int i = left + 1; i < right; ++i) {
				if (days[i] < days[left] || days[i] < days[right]) {
					left = i;
					right = i + k + 1;
					continue search;
				}
			}
			ans = Math.min(ans, Math.max(days[left], days[right]));
			left = right;
			right = left + k + 1;
		}

		return ans < Integer.MAX_VALUE ? ans : -1;
	}

	public static void main(String[] args) {
		P683KEmptySlots p = new P683KEmptySlots();
		System.out.println(p.kEmptySlots(new int[] { 1, 3, 6, 2, 4, 8, 5, 7 }, 2));
	}

}

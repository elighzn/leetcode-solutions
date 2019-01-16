package lc.medium;

import java.util.HashSet;
import java.util.Set;

public class P681NextClosestTime {
	public String nextClosestTime(String time) {
		Set<Integer> allowed = new HashSet<>();
		for (char c : time.toCharArray())
			if (c != ':')
				allowed.add(c - '0');

		int begin = Integer.parseInt(time.substring(0, 2)) * 60;
		begin += Integer.parseInt(time.substring(3));

		int minElapse = Integer.MAX_VALUE;
		final int DAY = 24 * 60;
		for (int a : allowed)
			for (int b : allowed) {
				int t1 = a * 10 + b;
				if (t1 < 24) {
					t1 *= 60;
					for (int c : allowed)
						for (int d : allowed) {
							int t2 = c * 10 + d;
							// System.out.println(t2);
							if (t2 < 60) {
								int t = t1 + t2;
								int elapse = Math.floorMod(t - begin, DAY);
								if (elapse > 0 && elapse < minElapse) {
									minElapse = elapse;
									time = "" + a + b + ':' + c + d;
								}
							}
						}
				}
			}

		return time;
	}

	public static void main(String[] args) {
		P681NextClosestTime p = new P681NextClosestTime();
		System.out.println(p.nextClosestTime("19:34"));
		System.out.println(p.nextClosestTime("00:00"));
	}

}

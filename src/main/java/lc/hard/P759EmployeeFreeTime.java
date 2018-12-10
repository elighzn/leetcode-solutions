package lc.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class P759EmployeeFreeTime {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> intervals = schedule.get(0);
		for (int i = 1; i < schedule.size(); i++) {
			intervals = union(intervals, schedule.get(i));
			System.out.println(intervals);
		}

		int i = 0;
		for (; i < intervals.size() - 1; i++) {
			Interval l = intervals.get(i);
			l.start = l.end;
			l.end = intervals.get(i + 1).start;
		}

		intervals.remove(i);
		return intervals;
	}

	List<Interval> union(List<Interval> l1, List<Interval> l2) {
		List<Interval> ans = new ArrayList<>();
		int p1 = 0, p2 = 0;

		while (p1 < l1.size() && p2 < l2.size()) {
			Interval a = l1.get(p1);
			Interval b = l2.get(p2);

			if (a.end < b.start) {
				ans.add(a);
				++p1;
			} else if (a.start > b.end) {
				ans.add(b);
				++p2;
			} else if (a.end >= b.start && a.start <= b.start) {
				// a.end = b.end;
				// ans.add(a);
				b.start = a.start;
				++p1;
				// ++p2;
			} else if (b.end >= a.start && b.start <= a.start) {
				// b.end = a.end;
				a.start = b.start;
				// ans.add(b);
				// ++p1;
				++p2;
			} else if (a.start <= b.start && a.end >= b.end) {
				++p2;
			} else if (a.start >= b.start && a.end <= b.end) {
				++p1;
			}
		}
		for (; p1 < l1.size(); p1++)
			ans.add(l1.get(p1));
		for (; p2 < l2.size(); p2++)
			ans.add(l2.get(p2));
		return ans;
	}

	public static void main(String[] args) {
		P759EmployeeFreeTime p = new P759EmployeeFreeTime();
	}

}

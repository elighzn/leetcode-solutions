package algorithms.examples.sort;

import java.util.Arrays;

import algorithms.examples.utils.StdOut;
import algorithms.examples.utils.StdRandom;

public class ThreeWayQuick extends Sort {

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	//Dijkstra 3-way partitioning
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi > lo) {
			int lt = lo, gt = hi;

			Comparable v = a[lo];
			int i = lo;
			while (i <= gt) {
				int cmp = a[i].compareTo(v);
				if (cmp < 0)
					exch(a, lt++, i++);
				else if (cmp > 0)
					exch(a, i, gt--);
				else
					i++;
			}
			sort(a, lo, lt - 1);
			sort(a, gt + 1, hi);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "sortexample";

		Character[] charArray = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		Arrays.stream(charArray).forEach(StdOut::print);
		sort(charArray);
		StdOut.println();
		Arrays.stream(charArray).forEach(StdOut::print);
	}
}

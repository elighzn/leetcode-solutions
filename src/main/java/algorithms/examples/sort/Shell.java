package algorithms.examples.sort;

import java.util.Arrays;

import algorithms.examples.utils.StdOut;

public class Shell extends Sort {

	public static void sort(Comparable[] a) {
		int N = a.length;

		int h = 1;
		while (h < N / 3) {
			// 1, 4, 13, 40, 121, 364
			h = 3 * h + 1;
		}

		while (h >= 1) {
			// h-sort the array.
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	public static void main(String[] args) {
		String s = "sortexample";

		Character[] charArray = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		Arrays.stream(charArray).forEach(StdOut::print);
		sort(charArray);
		StdOut.println();
		Arrays.stream(charArray).forEach(StdOut::print);
	}

}

package algorithms.examples.sort;

import java.util.Arrays;

import algorithms.examples.utils.StdOut;

public class Selection {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		boolean result = false;
		if (v.compareTo(w) < 0) {
			result = true;
		}
		return result;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
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

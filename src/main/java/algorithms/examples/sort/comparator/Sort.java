package algorithms.examples.sort.comparator;

import java.util.Comparator;

public class Sort {

	public static <T> void sort(T[] a, Comparator<T> comparator) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0 && less(comparator, a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	protected static <T> boolean less(Comparator<T> c, T v, T w) {
		return c.compare(v, w) < 0;
	}

	protected static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}

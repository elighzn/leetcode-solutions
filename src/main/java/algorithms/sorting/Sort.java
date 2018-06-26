package algorithms.sorting;

import java.util.Comparator;

public abstract class Sort {

	public final static boolean less(Comparable v, Comparable w) {
		boolean result = false;
		if (v.compareTo(w) < 0) {
			result = true;
		}
		return result;
	}

	public final static boolean less(Object v, Object w, Comparator comparator) {
		return comparator.compare(v, w) < 0;
	}

	public final static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// exchange a[i] and a[j] (for indirect sort)
	public final static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length);
	}

	// is the array a[lo..hi) sorted
	protected static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i < hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	protected static boolean isSorted(Object[] a, Comparator comparator) {
		return isSorted(a, 0, a.length, comparator);
	}

	// is the array a[lo..hi) sorted
	protected static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
		for (int i = lo + 1; i < hi; i++)
			if (less(a[i], a[i - 1], comparator))
				return false;
		return true;
	}
}

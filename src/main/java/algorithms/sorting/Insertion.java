package algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;
import algorithms.utils.StdOut;

public class Insertion extends Sort {

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param a
	 *            the array to be sorted
	 */
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
			assert isSorted(a, 0, i);
		}
		assert isSorted(a);
	}

	/**
	 * Rearranges the subarray a[lo..hi) in ascending order, using the natural
	 * order.
	 * 
	 * @param a
	 *            the array to be sorted
	 * @param lo
	 *            left endpoint (inclusive)
	 * @param hi
	 *            right endpoint (exclusive)
	 */
	public static void sort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i < hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
		assert isSorted(a, lo, hi);
	}

	/**
	 * Rearranges the array in ascending order, using a comparator.
	 * 
	 * @param a
	 *            the array
	 * @param comparator
	 *            the comparator specifying the order
	 */
	public static void sort(Object[] a, Comparator comparator) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j--) {
				exch(a, j, j - 1);
			}
			assert isSorted(a, 0, i, comparator);
		}
		assert isSorted(a, comparator);
	}

	/**
	 * Rearranges the subarray a[lo..hi) in ascending order, using a comparator.
	 * 
	 * @param a
	 *            the array
	 * @param lo
	 *            left endpoint (inclusive)
	 * @param hi
	 *            right endpoint (exclusive)
	 * @param comparator
	 *            the comparator specifying the order
	 */
	public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
		for (int i = lo; i < hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
				exch(a, j, j - 1);
			}
		}
		assert isSorted(a, lo, hi, comparator);
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

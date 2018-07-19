package princeton.algorithms.sorting;

import java.util.Arrays;
import princeton.algorithms.utils.StdOut;

public class Merge extends Sort {

	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi > lo) {
			int mid = lo + (hi - lo) / 2;
			sort(a, aux, lo, mid);
			sort(a, aux, mid + 1, hi);
			if (!(!less(a[mid + 1], a[mid])))
				merge(a, aux, lo, mid, hi);
		}
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		// copy
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
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

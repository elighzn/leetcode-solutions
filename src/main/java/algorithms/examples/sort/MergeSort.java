package algorithms.examples.sort;

public class MergeSort {

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

	}

}

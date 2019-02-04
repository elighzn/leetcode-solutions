package dummy;

import java.util.Arrays;

public class Sort {

	public static void mergesort(int[] arr) {
		if (arr == null || arr.length == 0)
			return;

		int[] aux = new int[arr.length];
		mergesort(arr, aux, 0, arr.length - 1);
	}

	private static void mergesort(int[] arr, int[] aux, int lo, int hi) {
		if (lo >= hi)
			return;

		int mid = lo + (hi - lo) / 2;

		mergesort(arr, aux, lo, mid);
		mergesort(arr, aux, mid + 1, hi);

		if (arr[mid] > arr[mid + 1])
			merge(arr, aux, lo, mid, hi);
	}

	private static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++)
			aux[k] = arr[k];

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				arr[k] = aux[j++];
			else if (j > hi)
				arr[k] = aux[i++];
			else if (aux[i] < aux[j])
				arr[k] = aux[i++];
			else
				arr[k] = aux[j++];
		}
	}

	public static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	private static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;

		int p = partition(arr, lo, hi);

		quicksort(arr, lo, p - 1);
		quicksort(arr, p + 1, hi);
	}

	public static int partition(int[] arr, int lo, int hi) {
		int j = lo - 1, pivot = arr[hi];

		for (int i = lo; i < hi; i++) {
			if (arr[i] > pivot)
				continue;

			j++;
			swap(arr, i, j);
		}
		swap(arr, j + 1, hi);
		return j;
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String[] args) {
		int[] input = { 10, 80, 30, 90, 40, 50, 70 };
		// quicksort(input);
		mergesort(input);
		System.out.println(Arrays.toString(input));
	}

}

package princeton.algorithms.sorting;

import java.util.Arrays;

import org.junit.Assert;

import princeton.algorithms.utils.StdOut;
import princeton.algorithms.utils.StdRandom;

public class Quick extends Sort {

	private static final int CUTOFF = 10;
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		
		if (hi > lo) {
			int j = partition(a, lo, hi);
			sort(a, lo, j - 1);
			sort(a, j + 1, hi);
		}
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		
		int j = lo;
		Comparable p = a[hi];
		for (int i = lo; i < hi; i++) {
			if (less(p, a[i]))
				continue;
			exch(a, i, j++);
		}
		exch(a, j, hi);
		return j;
		
//		int i = lo, j = hi + 1;
//		
//		while (true) {
//			while (less(a[++i], a[lo])) {
//				if (i == hi)
//					break;
//			}
//
//			while (less(a[lo], a[--j]));
//			
//			if (i >= j)
//				break;
//			exch(a, i, j);
//		}
//		exch(a, lo, j);
//		return j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "sortexample";

		Character[] charArray = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		Arrays.stream(charArray).forEach(StdOut::print);
		sort(charArray);
		StdOut.println();
		Arrays.stream(charArray).forEach(StdOut::print);
		
//		Assert.assertEquals("aeelmoprstx", new String((char[])charArray));
	}
}

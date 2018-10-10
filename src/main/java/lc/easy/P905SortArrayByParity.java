package lc.easy;

import java.util.Arrays;

public class P905SortArrayByParity {
	public int[] sortArrayByParity(int[] A) {
		if (A == null || A.length == 0)
			return A;

		int lo = 0, hi = A.length - 1;

		while (lo < hi) {
			while (lo < A.length - 1 && A[lo] % 2 == 0)
				lo++;

			while (hi > 0 && A[hi] % 2 == 1)
				hi--;

			if (lo < hi) {
				int tmp = A[lo];
				A[lo++] = A[hi];
				A[hi--] = tmp;
			}

		}
		return A;
	}

	public static void main(String[] args) {
		P905SortArrayByParity p = new P905SortArrayByParity();
		System.out.println(Arrays.toString(p.sortArrayByParity(new int[] { 3, 1, 2, 4 })));
	}

}

package lc.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

public class P254FactorCombinations {

	public List<List<Integer>> getFactors(int n) {
		if (n <= 1) {
			return new ArrayList<List<Integer>>();
		}

		int maxFactor = n - 1;
		List<Integer> factors = new ArrayList<>();
		for (int i = 2; i < maxFactor; i++) {
			if (n % i == 0) {
				factors.add(i);
				maxFactor = n / i;
				if (maxFactor != i)
					factors.add(factors.size(), maxFactor);
			}
		}
		
		List<List<Integer>> ans = new ArrayList<>();
		backtrack(ans, n, factors, 0, 1, new ArrayList<>());

		return ans;
	}

	void backtrack(final List<List<Integer>> ans, final int n, final List<Integer> factors, int i, int p,
			List<Integer> list) {
		if (p == n) {
			ans.add(new ArrayList<>(list));
			return;
		}

		if (p > n)
			return;

		for (int j = i; j < factors.size(); j++) {
			int f = factors.get(j);
			list.add(f);
			backtrack(ans, n, factors, j, p * f, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P254FactorCombinations p = new P254FactorCombinations();
		System.out.println(p.getFactors(1));
	}

}

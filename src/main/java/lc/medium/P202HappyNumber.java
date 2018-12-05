package lc.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P202HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (!set.contains(n)) {
			set.add(n);
			n = squareSum(n);
			if (n == 1)
				return true;
		}
		return false;
	}

	int squareSum(int n) {
		int sum = 0;
		char[] cArr = String.valueOf(n).toCharArray();
		for (char c : cArr) {
			int d = c - '0';
			sum += d * d;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		P202HappyNumber p = new P202HappyNumber();
		System.out.println(p.isHappy(2));
		System.out.println(p.isHappy(19));
		System.out.println(p.isHappy(39166461));
	}

}

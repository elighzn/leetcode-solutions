package lc.easy;

import java.util.ArrayList;
import java.util.List;

public class P412FizzBuzz {

	public List<String> fizzBuzz1(int n) {
		List<String> result = new ArrayList<>(n);

		if (n > 0) {
			for (int i = 1; i <= n; i++)
				result.add(String.valueOf(i));
			for (int i = 2; i < n; i += 3)
				result.set(i, "Fizz");
			for (int i = 4; i < n; i += 5)
				result.set(i, "Buzz");
			for (int i = 14; i < n; i += 15)
				result.set(i, "FizzBuzz");
		}

		return result;
	}

	public List<String> fizzBuzz2(int n) {
		List<String> result = new ArrayList<>(n);

		for (int i = 1; i <= n; i++) {
			boolean f1 = i % 3 == 0;
			boolean f2 = i % 5 == 0;
			if (f1 && f2)
				result.add("FizzBuzz");
			else if (f1)
				result.add("Fizz");
			else if (f2)
				result.add("Buzz");
			else
				result.add(String.valueOf(i));
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P412FizzBuzz p = new P412FizzBuzz();
		System.out.println(p.fizzBuzz1(5));
		System.out.println(p.fizzBuzz1(15));
	}

}

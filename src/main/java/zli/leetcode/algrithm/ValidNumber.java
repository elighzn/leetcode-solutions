package zli.leetcode.algrithm;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 */
public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber solution = new ValidNumber();
		String[] testString = new String[] { "0", " 0.1 ", "abc", "1 a", "2e10" };

		Stream<String> strStream = Arrays.stream(testString);
		Object[] trues = strStream.map(s -> solution.isNumber(s)).filter(Boolean::valueOf).toArray();

		Arrays.stream(trues).forEach(System.out::println);
	}

	public boolean isNumber(String s) {

		return true;
	}

}

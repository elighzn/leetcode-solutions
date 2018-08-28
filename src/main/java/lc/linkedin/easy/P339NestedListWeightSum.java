package lc.linkedin.easy;

import java.util.List;

import lc.commons.linkedin.NestedInteger;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger { // Constructor initializes an empty nested list. public
 * NestedInteger();
 *
 * // Constructor initializes a single integer. public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer. public void
 * setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it. public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class P339NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	int depthSum(List<NestedInteger> nestedList, int depth) {
		int total = 0;
		for (NestedInteger ni : nestedList)
			total += ni.isInteger() ? ni.getInteger() * depth : depthSum(ni.getList(), depth + 1);

		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

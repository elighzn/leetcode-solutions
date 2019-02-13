package lc.commons;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	/**
	 * Inorder deserialize.
	 * 
	 * @param nums
	 *            The inorder representation of the binary tree
	 * @return The root of the tree
	 */
	public static TreeNode deserialize(Integer[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		Deque<Integer> q = new LinkedList<>(Arrays.asList(nums));
		return deserialize(q);
	}

	static TreeNode deserialize(Deque<Integer> q) {
		Integer v = q.poll();
		if (v == null) return null;

		TreeNode root = new TreeNode(v);
		root.left = deserialize(q);
		root.right = deserialize(q);
		return root;
	}

	public String toString() {
		StringJoiner sj = new StringJoiner(",", "[", "]");
		inorder(this, sj);
		return sj.toString();
	}

	void inorder(TreeNode node, StringJoiner sj) {
		if (node == null) {
			sj.add("null");
			return;
		}
		sj.add(String.valueOf(node.val));
		inorder(node.left, sj);
		inorder(node.right, sj);
	}
}

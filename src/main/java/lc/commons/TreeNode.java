package lc.commons;

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

		return deserialize(nums, new int[1]);
	}

	static TreeNode deserialize(Integer[] vals, int[] i) {
		if (i[0] == vals.length)
			return null;
		Integer head = vals[i[0]++];
		if (head == null)
			return null;

		TreeNode root = new TreeNode(head);
		root.left = deserialize(vals, i);
		root.right = deserialize(vals, i);
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
		sj.add(node.val + "");
		inorder(node.left, sj);
		inorder(node.right, sj);
	}
}

package lc.commons;

import java.util.ArrayList;
import java.util.List;

public class BST {

	TreeNode root;

	public void add(int x) {
		root = add(root, x);
	}

	public TreeNode add(TreeNode node, int x) {
		if (node == null) {
			node = new TreeNode(x);
			return node;
		}
		if (node.val > x) {
			node.left = add(node.left, x);
		} else {
			node.right = add(node.right, x);
		}
		return node;
	}

	public TreeNode getRoot() {
		return this.root;
	}

	private List<Integer> toList() {
		List<Integer> list = new ArrayList<>();
		addToList(list, root);
		return list;
	}

	private void addToList(List<Integer> list, TreeNode node) {
		if (node.left != null)
			addToList(list, node.left);
		list.add(node.val);
		if (node.right != null)
			addToList(list, node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST bst = new BST();
		int[] input = { 3, 9, 7, 1, 4, 5, 3, 8, 10 };
		for (int i : input)
			bst.add(i);

		List<Integer> intList = bst.toList();
		System.out.println(intList);

	}

}

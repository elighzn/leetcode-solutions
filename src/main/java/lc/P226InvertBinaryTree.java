package lc;

import java.util.StringJoiner;

/**
 * Invert a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 *
 * 
 * 
 * Trivia: This problem was inspired by this original tweet by Max Howell:
 * 
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you
 * can’t invert a binary tree on a whiteboard so f*** off.
 * 
 * @author zhengli
 *
 */
public class P226InvertBinaryTree {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	private TreeNode root;

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		} else {
			TreeNode t = root.left;
			root.left = root.right;
			root.right = t;

			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}

	private void invert(TreeNode node) {

		if (node == null) {
			return;
		} else {
			TreeNode t = node.left;
			node.left = node.right;
			node.right = t;

			invert(node.left);
			invert(node.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P226InvertBinaryTree p = new P226InvertBinaryTree();
		BST bst = new BST();
		int[] a = { 1, 2, 3, 4, 6, 7, 9 };
		for (int i = 0; i < a.length; i++) {
			bst.add(a[i]);
		}
		System.out.println(bst);
		p.invertTree(bst.getRoot());
		
		System.out.println(bst);
	}

}

package lc.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import lc.commons.BST;
import lc.commons.TreeNode;

public class P173BinarySearchTreeIterator {

	public class BSTIterator {

		Deque<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack= new ArrayDeque<TreeNode>();
			if (root != null) {
				loadLeftSideOfTree(root);
			}
		}

		private void loadLeftSideOfTree(TreeNode node) {
			if (node != null) {
				stack.push(node);
				loadLeftSideOfTree(node.left);
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode current = stack.pop();
			this.loadLeftSideOfTree(current.right);
			return current.val;
		}
	}

	private BST initTree(int[] input) {
		BST bst = new BST();
		for (int i : input)
			bst.add(i);
		return bst;
	}

	public void run(int[] input) {
		BSTIterator i = new BSTIterator(initTree(input).getRoot());
		int j = 0;
		while (i.hasNext()) {
			input[j++] = i.next();
		}

		System.out.println(Arrays.toString(input));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P173BinarySearchTreeIterator p = new P173BinarySearchTreeIterator();
		p.run(new int[] {});
		p.run(new int[] { 3, 9, 7, 1, 4, 5, 3, 8, 10 });

	}

}

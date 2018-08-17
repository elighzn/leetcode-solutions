package lc.easy;

import lc.commons.TreeNode;

public class P104MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		return depth(root, 0);
	}
	
	private int depth(TreeNode node, int depth) {
		if (node==null)
			return depth;
		depth++;
		return Math.max(depth(node.left, depth), depth(node.right, depth));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

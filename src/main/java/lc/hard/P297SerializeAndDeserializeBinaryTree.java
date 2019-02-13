package lc.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import lc.commons.TreeNode;

public class P297SerializeAndDeserializeBinaryTree {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	static class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			se(root, sb);
			return sb.toString();
		}

		void se(TreeNode root, StringBuilder sb) {
			if (root == null) {
				sb.append("#,");
				return;
			}
			sb.append(root.val + ",");
			se(root.left, sb);
			se(root.right, sb);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null || data.length() == 0)
				return null;
			String[] ds = data.split(",");
			Deque<String> q = new LinkedList<>(Arrays.asList(ds));

			return de(q);
		}

		TreeNode de(Deque<String> q) {
			String v = q.poll();
			if (v == null || "#".equals(v))
				return null;

			TreeNode root = new TreeNode(Integer.valueOf(v));
			root.left = de(q);
			root.right = de(q);
			return root;
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	

	public static void main(String[] args) {
		Integer[] ins = new Integer[] { 1, 2, null, null, 3, 4, null, null, 5, null, null };
		Deque<String> q = new LinkedList<>();
		for (Integer i : ins) {
			if (i != null) q.offer(i.toString());
			else q.offer(null);
		}
		
		Codec c = new Codec();
		TreeNode root1 = c.de(q);
		System.out.println(root1);
		String data = c.serialize(root1);
		System.out.println(data);
		TreeNode root2 = c.deserialize(data);
		System.out.println(root2);
	}

}

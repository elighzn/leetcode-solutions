package lc.hard;

import java.util.Arrays;
import java.util.LinkedList;

import lc.commons.TreeNode;

public class P297SerializeAndDeserializeBinaryTree {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			inorder(root, sb);
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null || data.length() == 0)
				return null;

			String[] vals = data.split(" ");
			if (vals.length == 0 || "null".equals(vals[0]))
				return null;

			return deserialize(new LinkedList<>(Arrays.asList(vals)));
		}

		TreeNode deserialize(LinkedList<String> list) {
			String head = list.pollFirst();
			if (head == null || "#".equals(head))
				return null;

			TreeNode root = new TreeNode(Integer.valueOf(head));
			root.left = deserialize(list);
			root.right = deserialize(list);

			return root;
		}

		void inorder(TreeNode node, StringBuilder sb) {
			if (node == null) {
				sb.append("# ");
				return;
			}

			sb.append(node.val + " ");

			inorder(node.left, sb);
			inorder(node.right, sb);
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));

	public void run() {
		TreeNode root1 = TreeNode.deserialize(new Integer[] { 1, 2, null, null, 3, 4, 5, null, null, null, null });
		Codec c = new Codec();
		System.out.println(root1);
		String data = c.serialize(root1);
		System.out.println(data);
		TreeNode root2 = c.deserialize(data);
		System.out.println(root2);
	}

	public static void main(String[] args) {
		P297SerializeAndDeserializeBinaryTree p = new P297SerializeAndDeserializeBinaryTree();
		p.run();
	}

}

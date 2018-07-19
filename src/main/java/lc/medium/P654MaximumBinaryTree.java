package lc.medium;


import java.util.StringJoiner;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class P654MaximumBinaryTree {

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    TreeNode root = null;
    for (int i : nums) {
      root = add(root, i);
    }
    return root;
  }

  TreeNode add(TreeNode node, int x) {
    if (node == null) {
      node = new TreeNode(x);
    } else if (node.val > x) {
      node.right = add(node.right, x);
    } else {
      TreeNode root = new TreeNode(x);
      root.left = node;
      return root;
    }
    return node;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    public String toString() {
      StringJoiner sj = new StringJoiner(", ");
      sj.add(String.valueOf(val));
      if (left != null)
        sj.add(left.toString());
      if (right != null)
        sj.add(right.toString());
      return sj.toString();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P654MaximumBinaryTree p = new P654MaximumBinaryTree();

    int[] input = new int[] {3, 2, 1, 6, 0, 5};
    TreeNode root = p.constructMaximumBinaryTree(input);

    System.out.println(root);
  }

}

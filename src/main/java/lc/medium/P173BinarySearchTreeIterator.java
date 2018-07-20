package lc.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P173BinarySearchTreeIterator {

  public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode current;

    public BSTIterator(TreeNode root) {
      stack.clear();
      current = init(stack, root);
    }

    private TreeNode init(Stack<TreeNode> stack, TreeNode node) {
      stack.push(node);
      if (node.left != null) {
        init(stack, node.left);
      }
      return node;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

    }

    /** @return the next smallest number */
    public int next() {

    }
  }

  public class BST {

    TreeNode root;

    public void add(int x) {
      root = add(root, x);
    }

    private TreeNode add(TreeNode node, int x) {
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

    private List<Integer> toList() {
      List<Integer> list = new ArrayList<>();
      a(list, root);
      return list;
    }

    private void a(List<Integer> list, TreeNode node) {
      if (node.left != null)
        a(list, node.left);
      list.add(node.val);
      if (node.right != null)
        a(list, node.right);
    }

    public BSTIterator iterator() {
      return new BSTIterator(root);
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    public String toString() {
      return String.valueOf(val);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub


    BST bst = new BST();
    int[] input = {3, 9, 7, 1, 4, 5, 3, 8, 10};
    for (int i : input)
      bst.add(i);


  }

}

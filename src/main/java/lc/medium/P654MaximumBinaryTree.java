package lc.medium;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class P654MaximumBinaryTree {

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    // return constructMaximumBinaryTree(nums, 0, nums.length);

   int[] indices = new int[nums.length];
   
   
  }


  private TreeNode constructMaximumBinaryTree(int[] nums, int beginIndex, int endIndex) {

    if (beginIndex >= endIndex)
      return null;

    int max = getMax(nums, beginIndex, endIndex);

    TreeNode node = new TreeNode(nums[max]);
    node.left = constructMaximumBinaryTree(nums, beginIndex, max);
    node.right = constructMaximumBinaryTree(nums, max + 1, endIndex);

    return node;
  }

  static int getMax(int[] nums, int beginIndex, int endIndex) {
    int max = beginIndex;
    for (int i = beginIndex + 1; i < endIndex; i++)
      if (nums[i] > nums[max])
        max = i;
    return max;
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

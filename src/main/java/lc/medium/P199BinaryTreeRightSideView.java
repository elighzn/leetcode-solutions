package lc.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author zli
 *
 *         Given a binary tree, imagine yourself standing on the right side of it, return the values
 *         of the nodes you can see ordered from top to bottom.
 * 
 *         Example:
 * 
 *         Input: [1,2,3,null,5,null,4]
 * 
 *         Output: [1, 3, 4]
 * 
 *         Explanation:
 * 
 * 
 *         1 <---
 * 
 *         / \
 * 
 *         2 3 <---
 * 
 *         \ \
 * 
 *         5 4 <---
 * 
 */
public class P199BinaryTreeRightSideView {

  int maxDegree;

  public List<Integer> rightSideView(TreeNode root) {
    maxDegree = -1;
    List<Integer> list = new LinkedList<>();
    if (root != null) {
      getRightView(list, root, 0);
    }
    return list;
  }

  private void getRightView(List<Integer> list, TreeNode node, int currentDegree) {
    if (node != null) {
      if (currentDegree > maxDegree) {
        list.add(node.val);
        maxDegree = currentDegree;
      }
      if (node.right != null)
        getRightView(list, node.right, currentDegree + 1);
      if (node.left != null)
        getRightView(list, node.left, currentDegree + 1);
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
    P199BinaryTreeRightSideView p = new P199BinaryTreeRightSideView();

  }

}

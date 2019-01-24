package lc.easy;

public class P703KthLargestElementInAStream {

  class KthLargest {
    private KBST kbst = new KBST();
    private int k;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      for (int i : nums)
        kbst.insert(i);
    }

    public int add(int val) {
      kbst.insert(val);
      return kbst.getKthLargest();
    }

    class KBST {
      TreeNode root;
      int rightSize = 0;

      public KBST() {

      }

      int getKthLargest() {
        return root.val;
      }

      void insert(int val) {
        if (root == null) {
          root = new TreeNode(val);
          return;
        }

        if (val > root.val) {
          root.right = insert(root.right, val);
          rightSize++;
        }

        if (rightSize >= k) {
          TreeNode p = removeMin(root.right);
          if (p != root.right) {
            p.right = root.right;
          }
          root.right = null;
          p.left = root;
          root = p;
        }
      }

      TreeNode insert(TreeNode root, int val) {
        if (root == null)
          return new TreeNode(val);

        TreeNode node = root, prev = null;
        while (node != null && node.val != val) {
          prev = node;
          if (node.val > val)
            node = node.left;
          else
            node = node.right;
        }
        if (node == null) {
          if (prev.val > val)
            prev.left = new TreeNode(val);
          else
            prev.right = new TreeNode(val);
        } else {
          TreeNode p = new TreeNode(val);
          p.left = node.left;
          node.left = p;
        }
        return root;
      }

      TreeNode removeMin(TreeNode root) {
        if (root == null)
          return null;
        TreeNode node = root, prev = null;
        while (node.left != null) {
          prev = node;
          node = node.left;
        }
        if (prev != null)
          prev.left = node.right;
        return node;
      }
    }
  }

  class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
    }

    public String toString() {
      return String.valueOf(val);
    }
  }

  public void run() {
    KthLargest kL = new KthLargest(3, new int[] {4, 5, 8, 2});
    System.out.println(kL.add(3));
    System.out.println(kL.add(5));
    System.out.println(kL.add(10));
    System.out.println(kL.add(9));
    System.out.println(kL.add(4));
    System.out.println(kL.add(4));
  }

  public static void main(String[] args) {
    P703KthLargestElementInAStream p = new P703KthLargestElementInAStream();
    p.run();
  }

}

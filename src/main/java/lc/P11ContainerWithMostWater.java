package lc;

import org.junit.Assert;

/**
 * @author zli
 * 
 *         Given n non-negative integers a1, a2, ..., an, where each represents a point at
 *         coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is
 *         at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such
 *         that the container contains the most water.
 * 
 *         Note: You may not slant the container and n is at least 2.
 */
public class P11ContainerWithMostWater implements Solution {

  public int maxArea(int[] height) {

  }

  private int getArea(int left, int right, int distance) {
    return distance * Math.min(left, right);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution s = new P11ContainerWithMostWater();
    s.run();
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub

    int[] heights = new int[] {1, 3, 5, 8, 2, 5, 9};

    Assert.assertEquals(1, maxArea(heights));
  }

}

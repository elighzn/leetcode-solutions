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
public class P11ContainerWithMostWater {

  public int maxArea(int[] height) {
    if (height.length < 2)
      return 0;

    int maxRect = 0;
    int i = 0, j = height.length - 1;

    while (i < j) {

      int smallHeight = height[i] < height[j] ? height[i] : height[j];

      maxRect = Math.max((j-i) * smallHeight, maxRect);
      if (height[i] < height[j])
        i++;
      else
        j--;
    }
    return maxRect;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P11ContainerWithMostWater p = new P11ContainerWithMostWater();
    Assert.assertEquals(49, p.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }


}

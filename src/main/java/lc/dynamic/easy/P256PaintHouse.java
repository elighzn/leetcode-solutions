package lc.dynamic.easy;

public class P256PaintHouse {

  public int minCost(int[][] costs) {
    if (costs == null || costs.length < 1)
      return 0;

    int[] total = costs[0];

    for (int i = 1; i < costs.length; i++) {
      int[] currRow = new int[3];
      for (int j = 0; j < 3; j++)
        currRow[j] = costs[i][j] + Math.min(total[(j + 1) % 3], total[(j + 2) % 3]);
      total = currRow;
    }
    return Math.min(total[0], Math.min(total[1], total[2]));
  }

  public static void main(String[] args) {
    P256PaintHouse p = new P256PaintHouse();
    Assert.assertEquals(10, p.minCost(new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
  }
}
package lc.dynamic.easy;

import org.junit.Assert;

public class P256PaintHouse {

  public int minCost(int[][] costs) {
    if (costs == null || costs.length < 1)
      return 0;

    int[] total = costs[0];

    for (int i = 1; i < costs.length; i++) {
      int[] currRow = new int[3];
      for (int j = 0; j < 3; j++)
        currRow[j] = costs[i][j] + Math.min(total[(j + 1) % 3], total[(j + 2) % 3]);
      total = currRow;
    }
    return Math.min(total[0], Math.min(total[1], total[2]));
  }

  public static void main(String[] args) {
    P256PaintHouse p = new P256PaintHouse();
    Assert.assertEquals(10, p.minCost(new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
  }
}

package lc.google.medium;

import org.junit.Assert;

public class P807MaxIncreaseToKeepCitySkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] lr = new int[grid[0].length];
    int[] tb = new int[grid.length];

    for (int i = 0; i < tb.length; i++) {
      for (int j = 0; j < lr.length; j++) {
        if (lr[i] < grid[i][j])
          lr[i] = grid[i][j];
        if (tb[j] < grid[i][j])
          tb[j] = grid[i][j];
      }
    }
    int ans = 0;
    for (int i = 0; i < tb.length; i++) {
      for (int j = 0; j < lr.length; j++) {
        ans += Math.min(tb[j], lr[i]) - grid[i][j];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    P807MaxIncreaseToKeepCitySkyline p = new P807MaxIncreaseToKeepCitySkyline();
    int[][] in = new int[][] {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
    Assert.assertEquals(35, p.maxIncreaseKeepingSkyline(in));

  }

}

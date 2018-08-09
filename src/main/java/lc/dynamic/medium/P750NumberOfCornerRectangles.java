package lc.dynamic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

public class P750NumberOfCornerRectangles {
  public int countCornerRectangles(int[][] grid) {
    if (grid == null || grid.length < 2 || grid[0].length < 2)
      return 0;

    ArrayList<HashSet<Integer>> rowArray = new ArrayList<HashSet<Integer>>(grid.length);

    int total = 0;

    for (int i = 0; i < grid.length; ++i) {
      System.out.println(Arrays.toString(grid[i]));
      HashSet<Integer> row = new HashSet<>();
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1)
          row.add(j);
      }
      if (row.size() >= 2) {
        for (HashSet<Integer> preRow : rowArray) {
          if (preRow.size() >= 2) {
            int count = 0;
            for (int col : row) {
              if (preRow.contains(col))
                count++;
            }
            if (count > 1)
              total += count * (count - 1)/2;
          }
        }
        rowArray.add(row);
      }
    }
    return total;
  }

  public static void main(String[] args) {
    P750NumberOfCornerRectangles p = new P750NumberOfCornerRectangles();

    int[][] input =
        new int[][] {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}};

    Assert.assertEquals(1, p.countCornerRectangles(input));

    input = new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};

    Assert.assertEquals(9, p.countCornerRectangles(input));

    input = new int[][] {{1, 1, 1, 1}};

    Assert.assertEquals(0, p.countCornerRectangles(input));
  }

}

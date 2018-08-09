package lc.dynamic.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;

public class P750NumberOfCornerRectangles {
  public int countCornerRectangles(int[][] grid) {
    List<List<Integer>> rows = new ArrayList();
    int N = 0;
    for (int r = 0; r < grid.length; ++r) {
      rows.add(new ArrayList());
      for (int c = 0; c < grid[r].length; ++c)
        if (grid[r][c] == 1) {
          rows.get(r).add(c);
          N++;
        }
    }

    int sqrtN = (int) Math.sqrt(N);
    int ans = 0;
    Map<Integer, Integer> count = new HashMap();

    for (int r = 0; r < grid.length; ++r) {
      if (rows.get(r).size() >= sqrtN) {
        Set<Integer> target = new HashSet(rows.get(r));

        for (int r2 = 0; r2 < grid.length; ++r2) {
          if (r2 <= r && rows.get(r2).size() >= sqrtN)
            continue;
          int found = 0;
          for (int c2 : rows.get(r2))
            if (target.contains(c2))
              found++;
          ans += found * (found - 1) / 2;
        }
      } else {
        for (int i1 = 0; i1 < rows.get(r).size(); ++i1) {
          int c1 = rows.get(r).get(i1);
          for (int i2 = i1 + 1; i2 < rows.get(r).size(); ++i2) {
            int c2 = rows.get(r).get(i2);
            int ct = count.getOrDefault(200 * c1 + c2, 0);
            ans += ct;
            count.put(200 * c1 + c2, ct + 1);
          }
        }
      }
    }
    return ans;
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

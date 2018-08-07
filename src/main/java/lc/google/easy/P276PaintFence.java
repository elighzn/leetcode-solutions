package lc.google.easy;

import org.junit.Assert;

public class P276PaintFence {
  public int numWays(int n, int k) {
    if (n == 0)
      return 0;
    if (n == 1)
      return k;
    int k2 = k - 1;
    int same = k;
    int notSame = k * k2;

    for (int i = 2; i < n; i++) {
      int newSame = notSame;
      int newNotSame = same * k2 + notSame * k2;
      same = newSame;
      notSame = newNotSame;
    }
    return same + notSame;
  }

  public static void main(String[] args) {
    P276PaintFence p = new P276PaintFence();
    Assert.assertEquals(6, p.numWays(3, 2));
  }

}

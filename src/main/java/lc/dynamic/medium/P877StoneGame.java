package lc.dynamic.medium;

import java.util.Arrays;
import org.junit.Assert;

public class P877StoneGame {

//  public boolean stoneGame(int[] p) {
//
//    final int N = p.length;
//    int[][] dp = new int[N][N];
//
//    for (int i = 0; i < N; i++)
//      dp[i][i] = p[i];
//
//    for (int d = 1; d <= N - 1; d++)
//      for (int i = 0; i + d < N; i++) {
//        int j = i + d;
//        dp[i][j] = Math.max(p[i] - dp[i + 1][j], p[j] - dp[i][j - 1]);
//      }
//
//    return dp[0][N - 1] > 0;
//  }
  
  public boolean stoneGame(int[] p) {

    final int N = p.length;
    int[] dp = new int[N];

    dp = Arrays.copyOf(p, N);

    for (int d = 1; d <= N - 1; d++)
      for (int i = 0; i + d < N; i++) {
        int j = i + d;
        dp[i] = Math.max(p[i] - dp[i + 1], p[j] - dp[i]);
      }

    return dp[0] > 0;
  }

  public static void main(String[] args) {
    P877StoneGame p = new P877StoneGame();
    Assert.assertEquals(true, p.stoneGame(new int[] {3, 2, 10, 4}));
    Assert.assertEquals(true, p.stoneGame(new int[] {5, 3, 4, 5}));
  }

}

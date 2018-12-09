package lc.google.medium;

import java.util.ArrayList;
import java.util.List;

public class P935KnightDialer {


  public int knightDialer(int N) {
    if (N == 1)
      return 10;

    int[] dp = new int[10];
    for (int i = 0; i < 10; i++) {
      if (i == 5) {
      } else if (i == 4 || i == 6)
        dp[i] = 3;
      else
        dp[i] = 2;
    }

    for (int i = 1; i < N; i++) {
      
    }
  }

  int dfs(int N, int begining Number)

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

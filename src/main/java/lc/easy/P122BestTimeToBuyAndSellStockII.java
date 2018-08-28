package lc.easy;

import org.junit.Assert;

public class P122BestTimeToBuyAndSellStockII {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2)
      return 0;

    int hold = -prices[0], cash = 0;

    for (int i = 1; i < prices.length; i++) {
      cash = Math.max(cash, hold + prices[i]);
      hold = Math.max(hold, cash - prices[i]);
    }
    return cash;
  }

  public static void main(String[] args) {
    P122BestTimeToBuyAndSellStockII p = new P122BestTimeToBuyAndSellStockII();
    Assert.assertEquals(7, p.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    Assert.assertEquals(4, p.maxProfit(new int[] {1, 2, 3, 4, 5}));
    Assert.assertEquals(0, p.maxProfit(new int[] {7, 6, 4, 3, 1}));
  }

}

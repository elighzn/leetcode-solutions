package lc.google.easy;

import org.junit.Assert;

public class P121BestTimeToBuyAndSellStock {

  public int maxProfit(int prices[]) {
    if (prices == null || prices.length < 1) {
      return 0;
    }
    int maxProfit = 0;
    int minPrice = prices[0];
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice)
        minPrice = prices[i];
      else {
        int profit = prices[i] - minPrice;
        if (profit > maxProfit)
          maxProfit = profit;
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    P121BestTimeToBuyAndSellStock p = new P121BestTimeToBuyAndSellStock();
    Assert.assertEquals(1, p.maxProfit(new int[] {1, 2}));
    Assert.assertEquals(5, p.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    Assert.assertEquals(0, p.maxProfit(new int[] {7, 6, 4, 3, 1}));
  }

}

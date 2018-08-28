package lc.medium;

import org.junit.Assert;

/**
 * @author sfumato
 *
 *         Your are given an array of integers prices, for which the i-th element is the price of a
 *         given stock on day i; and a non-negative integer fee representing a transaction fee.
 * 
 *         You may complete as many transactions as you like, but you need to pay the transaction
 *         fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you
 *         must sell the stock share before you buy again.)
 * 
 *         Return the maximum profit you can make.
 * 
 *         Example 1:
 * 
 *         Input: prices = [1, 3, 2, 8, 4, 9], fee = 2 Output: 8
 * 
 *         Explanation: The maximum profit can be achieved by:
 * 
 *         Buying at prices[0] = 1
 * 
 *         Selling at prices[3] = 8
 * 
 *         Buying at prices[4] = 4
 * 
 *         Selling at prices[5] = 9
 * 
 *         The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 *         Note:
 * 
 *         0 < prices.length <= 50000.
 * 
 *         0 < prices[i] < 50000.
 * 
 *         0 <= fee < 50000.
 * 
 */
public class P714BestTimeToBuyAndSellStockWithTransactionFee {

  public int maxProfit(int[] prices, int fee) {
    int cash = 0, hold = -prices[0];
    for (int i = 1; i < prices.length; i++) {

      cash = Math.max(cash, hold + prices[i] - fee);
      hold = Math.max(hold, cash - prices[i]);
      System.out.printf("cash: %d, hold:%d\n", cash, hold);
    }
    return cash;
  }

  public static void main(String[] args) {

    P714BestTimeToBuyAndSellStockWithTransactionFee p =
        new P714BestTimeToBuyAndSellStockWithTransactionFee();
    Assert.assertEquals(8, p.maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
  }

}

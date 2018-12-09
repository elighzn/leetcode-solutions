package coursera;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

/**
 * @author sfumato
 *
 *         Cutting Metal Surplus
 * 
 *         The owner of a medal rod factory has a surplus of rods of arbitrary lengths. A local
 *         contractor offers to buy any of the factory's surplus as long as all the rods have the
 *         same exact integer length, referred to as saleLength. The factory owner can increase the
 *         number of sellable rods by cutting each rod zero or more times, but each cut has a cost
 *         denoted by costPerCut. After all cuts have been made, any leftover rods having a length
 *         other than the saleLength must be discarded for no profit. The factory owner's total
 *         profit for the sale is calculated as:
 * 
 *         totalProfit = totalUnitformRods x saleLength x salePrice - totalCuts x costPerCut
 * 
 *         where totalUniformRods is the number of sellable rods, salePrice is the per-rod price
 *         that the contractor agrees to pay, and totalCuts is the total number of times the rods
 *         needed to be cut. For example, the owner has three rods, lengths = [30, 59, 110]. The
 *         costPercut = 1 and the salePrice = 10 per unit length. The following are tests based on
 *         lengths that are factors of 30, the length of the shortest bar. Factors of other lengths
 *         might also be tested, but this will demonstrate the methodology.
 * 
 *         Working through the first stanza, Length = 30, it's the same length as the first rod, cut
 *         and discard the excess 29 unit rods. No more cuts are necessary and have another 1 piece
 *         to sell. Cut 20 units off the 110 unit rod to discard leaving 90 units, then make two
 *         more cuts to have 3 more pieces to sell. Finally sell 5 totalUniformRods, saleLength - 30
 *         at salePrice = 10 per unit length for 1500. The cost to produce was totalCuts = 4 times
 *         costPerCut = 4 times costPerCut = 1 per cuts, or 4. Total revenue = 1500 - 4 = 1496. The
 *         maximum revenue among these tests is obtained at length 5: 1913.
 * 
 *         Function Description Complete the function maxProfit in the editor below. The function
 *         must return an integer denoting the maximum possible profit.
 * 
 * 
 */
public class CuttingMetalSurplus {

  public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
    int saleLength = 1, maxProfit = Integer.MIN_VALUE, profit = 1;

    while (profit > 0) {
      profit = getProfit(costPerCut, salePrice, lengths, saleLength++);
      if (maxProfit < profit)
        maxProfit = profit;
    }
    return maxProfit;
  }

  public static int getProfit(int costPerCut, int salePrice, List<Integer> lengths,
      int saleLength) {
    int totalCuts = 0, totalPieces = 0;
    for (int length : lengths) {
      int pieces = length / saleLength;
      int extra = length % saleLength;
      totalCuts += extra == 0 ? pieces - 1 : pieces;
      totalPieces += pieces;
    }
    return totalPieces * saleLength * salePrice - costPerCut * totalCuts;
  }

  public static int cut(int length, int saleLength) {
    int pieces = length / saleLength;
    int extra = length % saleLength;
    return extra == 0 ? pieces - 1 : pieces;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    CuttingMetalSurplus p = new CuttingMetalSurplus();
    Assert.assertEquals(1913,
        CuttingMetalSurplus.maxProfit(1, 10, Arrays.asList(new Integer[] {30, 59, 110})));
    Assert.assertEquals(1770,
        CuttingMetalSurplus.maxProfit(1, 10, Arrays.asList(new Integer[] {26, 103, 59})));
  }

}

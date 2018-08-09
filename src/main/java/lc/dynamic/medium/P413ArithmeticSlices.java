package lc.dynamic.medium;

import org.junit.Assert;

public class P413ArithmeticSlices {

  public int numberOfArithmeticSlices(int[] A) {
    if (A == null || A.length < 3)
      return 0;

    int total = 0;

    int[] ari = new int[A.length - 1];

    for (int i = 0; i < A.length - 1; i++) {
      ari[i] = A[i + 1] - A[i];
    }

    boolean[] arr = new boolean[ari.length - 1];

    for (int l = 2; l < A.length; l++) {
      for (int i = 0; i < ari.length - l + 2; i++) {
        System.out.print(i);
      }
      System.out.println();
    }

    return total;
  }



  public static void main(String[] args) throws Exception {
    P413ArithmeticSlices p = new P413ArithmeticSlices();
    Assert.assertEquals(10, p.numberOfArithmeticSlices(new int[] {1, 2, 3, 4, 5, 6}));
    Assert.assertEquals(3, p.numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
    Assert.assertEquals(1, p.numberOfArithmeticSlices(new int[] {1, 2, 4, 5, 6}));
  }

}

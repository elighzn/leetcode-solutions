package lc.dynamic.medium;

import org.junit.Assert;

public class P413ArithmeticSlices {

  // public int numberOfArithmeticSlices(int[] A) {
  // if (A == null || A.length < 3)
  // return 0;
  //
  // int total = 0;
  //
  // int[] ari = new int[A.length - 1];
  //
  // for (int i = 0; i < A.length - 1; i++) {
  // ari[i] = A[i + 1] - A[i];
  // }
  //
  // boolean[] arr = new boolean[ari.length - 1];
  // for (int i = 0; i < ari.length - 1; i++) {
  // arr[i] = ari[i] == ari[i + 1];
  // if (arr[i])
  // total++;
  // }
  //
  //
  // int l = 2;
  // while (A.length - l > 0) {
  // for (int i = 0; i < ari.length - l; i++) {
  // if (arr[i])
  // if (ari[i] != ari[i + l])
  // arr[i] = false;
  // else
  // total++;
  //
  // }
  // l++;
  // }
  // return total;
  // }

  public int numberOfArithmeticSlices(int[] A) {
    int curr = 0, sum = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        curr += 1;
        sum += curr;
      } else {
        curr = 0;
      }
    }
    return sum;
  }

  public static void main(String[] args) throws Exception {
    P413ArithmeticSlices p = new P413ArithmeticSlices();
    Assert.assertEquals(10, p.numberOfArithmeticSlices(new int[] {1, 2, 3, 4, 5, 6}));
    Assert.assertEquals(3, p.numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
    Assert.assertEquals(1, p.numberOfArithmeticSlices(new int[] {1, 2, 4, 5, 6}));
    Assert.assertEquals(7,
        p.numberOfArithmeticSlices(new int[] {1, 3, 5, 7, 9, 15, 20, 25, 28, 29}));
  }

}

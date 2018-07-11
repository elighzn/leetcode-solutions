package lc.google;

import org.junit.Assert;

public class P852PeakIndexInAMountainArray {

//  public int peakIndexInMountainArray(int[] A) {
//    int leftmost = 0;
//    int rightmost = A.length - 1;
//    boolean notTop;
//    int i;
//    do {
//      i = (leftmost + rightmost) / 2;
//      boolean left = A[i - 1] > A[i];
//      boolean right = A[i + 1] > A[i];
//
//      notTop = left || right;
//      if (left) {
//        rightmost = i;
//      } else if (right) {
//        leftmost = i;
//      }
//    } while (notTop);
//
//    return i;
//  }

  public int peakIndexInMountainArray(int[] A) {
    int lo = 0, hi = A.length - 1;
    while (lo < hi) {
        int mi = lo + (hi - lo) / 2;
        if (A[mi] < A[mi + 1])
            lo = mi + 1;
        else
            hi = mi;
    }
    return lo;
}

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P852PeakIndexInAMountainArray p = new P852PeakIndexInAMountainArray();
    int[] input;

    input = new int[] {0, 1, 0};
    Assert.assertEquals(1, p.peakIndexInMountainArray(input));

    input = new int[] {0, 2, 1, 0};
    Assert.assertEquals(1, p.peakIndexInMountainArray(input));

    input = new int[] {0, 2, 4, 8, 9, 10, 7, 5, 4, 0};
    Assert.assertEquals(5, p.peakIndexInMountainArray(input));
  }

}

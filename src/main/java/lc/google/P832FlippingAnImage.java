package lc.google;

import java.util.Arrays;
import org.junit.Assert;

public class P832FlippingAnImage {

  public int[][] flipAndInvertImage(int[][] A) {
    for (int[] a : A) {
      flipAndInvertImage(a);
    }
    return A;
  }

  private void flipAndInvertImage(int[] A) {
    flip(A);
    invert(A);
  }

  private void flip(int[] a) {
    int b;
    int n = a.length / 2;
    n = a.length % 2 == 0 ? n -= 1 : n;
    for (int i = 0; i <= n; i++) {
      b = a[i];
      a[i] = a[a.length - i - 1];
      a[a.length - i - 1] = b;
    }
    System.out.println();
  }

  private void invert(int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] ^= 1;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P832FlippingAnImage p = new P832FlippingAnImage();
    int[] input = {1, 1, 0};
    int[] expecteds = {1, 0, 0};

    // int[] result = p.flipAndInvertImage(input);
    System.out.println(Arrays.toString(input));
    p.flipAndInvertImage(input);
    System.out.println(Arrays.toString(input));
    Assert.assertArrayEquals(expecteds, input);

    input = new int[] {1, 1, 0, 0};
    expecteds = new int[] {1, 1, 0, 0};
    System.out.println(Arrays.toString(input));
    p.flipAndInvertImage(input);
    System.out.println(Arrays.toString(input));
    Assert.assertArrayEquals(expecteds, input);


  }

}

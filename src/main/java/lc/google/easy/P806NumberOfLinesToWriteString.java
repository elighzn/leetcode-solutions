package lc.google.easy;

import org.junit.Assert;

public class P806NumberOfLinesToWriteString {
  public int[] numberOfLines(int[] widths, String S) {
    int[] ans = new int[2];
    int totalLength = 0;
    int rows = 1;
    for (int i = 0; i < S.length(); i++) {
      totalLength += widths[S.charAt(i) - 'a'];
      if (totalLength > 100) {
        totalLength = widths[S.charAt(i) - 'a'];
        rows++;
      }
    }
    ans[0] = rows;
    ans[1] = totalLength;
    return ans;
  }

  public static void main(String[] args) {
    P806NumberOfLinesToWriteString p = new P806NumberOfLinesToWriteString();

    Assert.assertArrayEquals(new int[] {2, 4},
        p.numberOfLines(new int[] {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"));

    Assert.assertArrayEquals(new int[] {3, 60},
        p.numberOfLines(new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz"));
  }

}

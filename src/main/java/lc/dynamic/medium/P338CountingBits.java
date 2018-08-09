package lc.dynamic.medium;

import org.junit.Assert;

public class P338CountingBits {
  
  public int[] countBits(int num) {
    
  }

  public static void main(String[] args) {
    P338CountingBits p = new P338CountingBits();
    Assert.assertArrayEquals(new int[] {0, 1, 1}, p.countBits(2));
    Assert.assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2}, p.countBits(5));
  }
}

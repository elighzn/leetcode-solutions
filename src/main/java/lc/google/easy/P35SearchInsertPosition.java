package lc.google.easy;

import org.junit.Assert;

public class P35SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0)
      return 0;

    int lo = 0, hi = nums.length - 1;

    if (target <= nums[lo])
      return lo;
    else if (target == nums[hi])
      return hi;
    else if (target > nums[hi])
      return hi + 1;
    else {
      while (lo <= hi) {
        int mid = (lo + hi) / 2;
        if (target == nums[mid])
          return mid;
        else if (target > nums[mid])
          lo = mid + 1;
        else
          hi = mid - 1;
      }
      return lo;
    }
  }



  public static void main(String[] args) {
    P35SearchInsertPosition p = new P35SearchInsertPosition();
    Assert.assertEquals(1, p.searchInsert(new int[] {1, 3}, 2));
    Assert.assertEquals(1, p.searchInsert(new int[] {1, 3}, 3));
    Assert.assertEquals(2, p.searchInsert(new int[] {1, 2, 4, 6, 7}, 3));

    Assert.assertEquals(2, p.searchInsert(new int[] {1, 3, 5, 6}, 5));
    Assert.assertEquals(1, p.searchInsert(new int[] {1, 3, 5, 6}, 2));
    Assert.assertEquals(4, p.searchInsert(new int[] {1, 3, 5, 6}, 7));
    Assert.assertEquals(0, p.searchInsert(new int[] {1, 3, 5, 6}, 0));

  }

}

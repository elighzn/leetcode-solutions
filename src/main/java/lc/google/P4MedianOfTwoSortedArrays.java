package lc.google;

import org.junit.Assert;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * 
 * nums1 = [1, 3]
 * 
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2:
 * 
 * nums1 = [1, 2]
 * 
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author zli
 *
 */
public class P4MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    return findMedianSortedArrays(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
  }

  double findMedianSortedArrays(int[] nums1, int[] nums2, int nums1Begin, int nums1End,
      int nums2Begin, int nums2End) {

    int nums1Length = nums1End - nums1Begin + 1;
    int nums2Length = nums2End - nums2Begin + 1;

    if (nums1Length > 0 && nums2Length > 0) {
      if (nums1[nums1End] < nums2[nums2Begin]) {
        return getMedian(nums1, nums2, nums1Begin, nums1End, nums2Begin, nums2End);
      } else if (nums1[nums1Begin] > nums2[nums2End]) {
        return getMedian(nums2, nums1, nums2Begin, nums2End, nums1Begin, nums1End);
      } else {
        if (nums1[nums1Begin] < nums2[nums2Begin]) {
          nums1Begin++;
        } else {
          nums2Begin++;
        }

        if (nums1[nums1End] < nums2[nums2End]) {
          nums2End--;
        } else {
          nums1End--;
        }
        return findMedianSortedArrays(nums1, nums2, nums1Begin, nums1End, nums2Begin, nums2End);
      }
    } else if (nums1Length == 0 && nums2Length > 0) {
      return getMedian(nums1, nums2, nums1Begin, nums1End, nums2Begin, nums2End);
    } else {
      return getMedian(nums2, nums1, nums2Begin, nums2End, nums1Begin, nums1End);
    }
  }

  private double getMedian(int[] s, int[] l, int sBegin, int sEnd, int lBegin, int lEnd) {
    int sLength = sEnd - sBegin + 1;
    int lLength = lEnd - lBegin + 1;
    int totalLength = sLength + lLength;
    double half = totalLength / 2;
    int modulo = totalLength % 2;

    int h = (int) half;

    double m = h < sLength ? s[sBegin + h] : l[h - sLength + lBegin];

    if (modulo > 0) {
      return m;
    } else {
      int h2 = h - 1;
      double m2 = h2 < sLength ? s[sBegin + h2] : l[h2 - sLength + lBegin];
      return 0.5 * (m + m2);
    }
  }

  public static void main(String[] args) {
    P4MedianOfTwoSortedArrays p = new P4MedianOfTwoSortedArrays();
    double median;

    median = p.findMedianSortedArrays(new int[] {1, 2}, new int[] {3});
    System.out.println(median);
    Assert.assertTrue(median == 2);

    median = p.findMedianSortedArrays(new int[] {1}, new int[] {});
    System.out.println(median);
    Assert.assertTrue(median == 1);

    median = p.findMedianSortedArrays(new int[] {}, new int[] {1});
    System.out.println(median);
    Assert.assertTrue(median == 1);


    median = p.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4});
    System.out.println(median);
    Assert.assertTrue(median == 2.5);



    median = p.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4});
    System.out.println(median);
    Assert.assertTrue(median == 2.5);

    median = p.findMedianSortedArrays(new int[] {1, 4}, new int[] {2, 3});
    System.out.println(median);
    Assert.assertTrue(median == 2.5);

    median = p.findMedianSortedArrays(new int[] {1, 4}, new int[] {2, 3, 5, 6, 7, 8, 9});
    System.out.println(median);
    Assert.assertTrue(median == 5);
  }
}

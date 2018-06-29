package lc.google;

import java.util.Arrays;

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

  public void findMedianSortedArrays(int[] nums1, int[] nums2) {

    int i = 0;
    int j = 0;

    int totalLength = nums1.length + nums2.length;
    
    double m_temp = (double) totalLength / 2;
    
    int m = (int) m_temp;

    int[] nums = new int[totalLength];
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] <= nums2[j]) {
        nums[i + j] = nums1[i];
        i++;
      } else {
        nums[i + j] = nums2[j];
        j++;
      }
    }
    if (i < nums1.length)
      for (; i < nums1.length; i++)
        nums[i + j] = nums1[i];

    else if (j < nums2.length) {
      for (; j < nums1.length; j++)
        nums[i + j] = nums2[j];
    }
    System.out.println(Arrays.toString(nums));
  }

  public static void main(String[] args) {
    P4MedianOfTwoSortedArrays p = new P4MedianOfTwoSortedArrays();


    p.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4});

    double a = (double) 5 / 2;
    System.out.println(a);
    System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(a)));



  }
}

package lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P15ThreeSum {

  // public List<List<Integer>> threeSum(int[] nums) {
  // return threeSum(nums, 0);
  // }

  public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>();
    for (int i = 0; i < num.length - 2; i++) {
      if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
        int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
        while (lo < hi) {
          if (num[lo] + num[hi] == sum) {
            res.add(Arrays.asList(num[i], num[lo], num[hi]));
            while (lo < hi && num[lo] == num[lo + 1])
              lo++;
            while (lo < hi && num[hi] == num[hi - 1])
              hi--;
            lo++;
            hi--;
          } else if (num[lo] + num[hi] < sum)
            lo++;
          else
            hi--;
        }
      }
    }
    return res;
  }

  public List<List<Integer>> threeSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length < 3)
      return result;

    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0, j = i + 1, k = nums.length - 1; i < nums.length - 2; i++, j = i + 1, k =
        nums.length - 1) {
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == target) {
          set.add(Arrays.asList(nums[i], nums[j], nums[k]));
        }
        if (sum < target) {
          j++;
        } else {
          k--;
        }
      }
    }
    result.addAll(set);
    return result;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P15ThreeSum p = new P15ThreeSum();

    long ts1 = System.nanoTime();
    p.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    p.threeSum(new int[] {7, -10, 7, 3, 14, 3, -2, -15, 7, -1, -7, 6, -5, -1, 3, -13, 6, -15, -10,
        14, 8, 5, -10, -1, 1, 1, 11, 6, 8, 5, -4, 0, 3, 10, -12, -6, -2, -6, -6, -10, 8, -5, 12, 10,
        1, -8, 4, -8, -8, 2, -9, -15, 14, -11, -1, -8, 5, -13, 14, -2, 0, -13, 14, -12, 12, -13, -3,
        -13, -12, -2, -15, 4, 8, 4, -1, -6, 11, 11, -7, -12, -2, -8, 10, -3, -4, -6, 4, -14, -12,
        -5, 0, 3, -3, -9, -2, -6, -15, 2, -11, -11, 8, -11, 8, -7, 8, 14, -5, 4, 10, 3, -1, -15, 10,
        -6, -11, 13, -5, 1, -15});
    long ts2 = System.nanoTime();
    long lapse = ts2 - ts1;
    lapse /= 1000000;
    System.out.println(lapse);
  }

}

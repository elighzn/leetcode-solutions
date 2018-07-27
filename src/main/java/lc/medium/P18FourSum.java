package lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {

    Arrays.sort(nums);

    System.out.println(Arrays.toString(nums));

    int[] p = new int[] {0, 1, 2, nums.length - 1};

    int total = 0;
    List<List<Integer>> result = new ArrayList<>();

    for (; p[0] < nums.length - 3; p[0]++, p[1] = p[0] + 1, p[2] = p[1] + 1, p[3] =
        nums.length - 1) {

      while (p[2] < p[3]) {
        total = sum(nums, p);
        if (total == target) {
          add(result, p);
        }
        System.out.printf("p: %s, total: %d\n", Arrays.toString(p), total);
        if (total > target) {
          p[3]--;
        } else {
          p[1]++;
          p[2]++;
        }
      }
    }
    return result;
  }

  static void add(List<List<Integer>> list, int... nums) {
    List<Integer> l = new ArrayList<>();
    for (int i : nums)
      l.add(i);
    list.add(l);
  }

  static int sum(int[] nums, int[] indices) {
    int sum = 0;
    for (int i : indices) {
      sum += nums[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P18FourSum p = new P18FourSum();
    // System.out.println(p.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));

    System.out.println(p.fourSum(new int[] {-3, -1, 0, 2, 4, 5}, 2));
  }

}

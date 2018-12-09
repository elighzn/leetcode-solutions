package lc.amazon.easy;

import java.util.Arrays;

public class P167TwoSumIIInputArrayIsSorted {
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length < 1)
      return numbers;

    int lo = 0, hi = numbers.length - 1;
    while (lo < hi) {
      int sum = numbers[lo] + numbers[hi];
      if (sum == target)
        return new int[] {lo + 1, hi + 1};
      else if (sum < target)
        lo++;
      else
        hi--;
    }
    return null;
  }

  public static void main(String[] args) {
    P167TwoSumIIInputArrayIsSorted p = new P167TwoSumIIInputArrayIsSorted();
    System.out.println(Arrays.toString(p.twoSum(new int[] {5, 25, 75}, 100)));
    System.out.println(Arrays.toString(p.twoSum(new int[] {-1, 0}, -1)));
  }

}

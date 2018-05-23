package lc.problems;

/*
 * Given an array with n integers, your task is to check if it could become non-decreasing by
 * modifying at most 1 element.
 * 
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * 
 * Example 1: Input: [4,2,3] Output: True Explanation: You could modify the first 4 to 1 to get a
 * non-decreasing array. Example 2: Input: [4,2,1] Output: False Explanation: You can't get a
 * non-decreasing array by modify at most one element. Note: The n belongs to [1, 10,000].
 */
public class P665NonDecreasingArray {
  
  public boolean checkPossibility(int[] nums) {
    if (nums.length > 2) {
      int N = nums.length;
      int count = 0;

      for (int i = 0; i < N - 1; i++) {
        if (nums[i] > nums[i + 1]) {
          if (i == 0 || i == N - 1) {
            if (++count > 1) {
              return false;
            }
          } else if (N > 3 && i < N - 2 && isOutOfRange(nums[i], nums[i - 1], nums[i + 2])
              && isOutOfRange(nums[i + 1], nums[i - 1], nums[i + 2])) {
            return false;
          } else {
            if (++count > 1) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  private boolean isOutOfRange(int number, int a, int b) {
    int min, max;
    if (a < b) {
      min = a;
      max = b;
    } else {
      min = b;
      max = a;
    }
    return number < min || number > max;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P665NonDecreasingArray p = new P665NonDecreasingArray();
    assert p.checkPossibility(new int[] {-1, 4, 2, 3}) == true;
    assert p.checkPossibility(new int[] {1, 1, 3, 5, 2, 4, 9}) == false;
    assert p.checkPossibility(new int[] {4, 2, 3}) == true;
    assert p.checkPossibility(new int[] {2, 3, 3, 2, 4}) == true;
    assert p.checkPossibility(new int[] {4, 2, 1}) == false;
    assert p.checkPossibility(new int[] {1, 2, 3, 5, 4}) == true;
    assert p.checkPossibility(new int[] {3, 3, 2, 2}) == false;
  }

}

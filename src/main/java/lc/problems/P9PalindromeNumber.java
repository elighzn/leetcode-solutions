package lc.problems;

/*
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same
 * backward as forward.
 * 
 * Example 1:
 * 
 * Input: 121 Output: true Example 2:
 * 
 * Input: -121 Output: false Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome. Example 3:
 * 
 * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome. Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 */
public class P9PalindromeNumber {


  public boolean isPalindrome(int x) {

    int firstD = getFirstDigit(x);
    int lastD = getLastDigit(x);
    int d = getD(x);

    while (firstD == lastD && d > 1) {
      x = (x - firstD * (int) Math.pow((double) 10, (double) d) - lastD) / 10;
      firstD = getFirstDigit(x);
      lastD = getLastDigit(x);
      d = getD(x);
      System.out.println(x);
    }
    return true;
  }

  private int getD(int x) {
    int d = 1;
    while (x >= 10) {
      d++;
      x /= 10;
    }
    return d;
  }

  private int getFirstDigit(int x) {
    while (x >= 10)
      x /= 10;
    return x;
  }

  private int getLastDigit(int x) {
    return x % 10;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P9PalindromeNumber p = new P9PalindromeNumber();
    p.isPalindrome(12321);
    p.isPalindrome(12321);
  }

}

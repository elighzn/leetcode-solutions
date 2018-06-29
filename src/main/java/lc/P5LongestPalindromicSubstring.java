package lc;

import org.junit.Assert;

/**
 * @author zli
 * 
 *         Given a string s, find the longest palindromic substring in s. You may assume that the
 *         maximum length of s is 1000.
 * 
 *         Example 1:
 * 
 *         Input: "babad"
 * 
 *         Output: "bab"
 * 
 *         Note: "aba" is also a valid answer.
 * 
 *         Example 2:
 * 
 *         Input: "cbbd"
 * 
 *         Output: "bb"
 */
public class P5LongestPalindromicSubstring {

   public String longestPalindrome(String s) {
     if (isPalindramic(s)) {
       return s;
     } else {
       longestPalindrome(s.substring(1));
       
     }
   }
   
   

  static boolean isPalindramic(String s) {
    int n = s.length() / 2;
    int a = s.length() - 1;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != s.charAt(a - i))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P5LongestPalindromicSubstring p = new P5LongestPalindromicSubstring();
    Assert.assertEquals(true, p.isPalindramic("abba"));
  }

}

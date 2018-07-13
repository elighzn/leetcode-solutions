package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Assert;

/**
 * @author sfumato
 *
 *         The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like
 *         this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 *         P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * 
 *         Write the code that will take a string and make this conversion given a number of rows:
 * 
 *         string convert(string s, int numRows); Example 1:
 * 
 *         Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR"
 * 
 *         P A H N
 * 
 *         A P L S I I G
 * 
 *         Y I R
 * 
 *         Example 2:
 * 
 *         Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI"
 * 
 *         Explanation:
 * 
 *         P I N
 * 
 *         A L S I G
 * 
 *         Y A H R
 * 
 *         P I
 */
public class P6ZigZagConversion {

  public String convert(String s, int numRows) {
    if (numRows < 2) {
      return s;
    }
    int n = s.length() / (numRows - 1) + 1;
    Character[][] strs = new Character[numRows][];

    for (int i = 0; i < strs.length; i++) {
      strs[i] = new Character[n];
    }

    int k = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < numRows; j++) {
        strs[j][i] = s.charAt(k++);
        if (k == s.length())
          return a(strs);
      }
      i++;
      for (int j = numRows - 2; j > 0; j--) {
        strs[j][i] = s.charAt(k++);
        if (k == s.length())
          return a(strs);
      }
    }
    return a(strs);
  }

  String a(Character[][] strs) {
    String s = new String();
    for (Character[] str : strs) {
      for (Character c : str) {
        if (c != null)
          s += c;
      }
    }
    return s;
  }



  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P6ZigZagConversion p = new P6ZigZagConversion();
    Assert.assertEquals(p.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
    Assert.assertEquals(p.convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
    Assert.assertEquals("ACB", p.convert("ABC", 2));
    Assert.assertEquals("", p.convert("", 1));
    Assert.assertEquals(p.convert("A", 2), "A");
    Assert.assertEquals(p.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
    Assert.assertEquals(p.convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
  }

}

package lc;

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
 *         Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR" Example 2:
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

    char[] sc = s.toCharArray();
    if (numRows <= 1 || s.isEmpty() || sc.length <= numRows) {
      return s;
    }

    int width = (sc.length - 1) / (numRows - 1);
    int q = (sc.length - 1) % (numRows - 1);
    width = q == 0 ? width : width + 1;

    char[][] zigzag = new char[numRows][width];

    a(zigzag, width, numRows, sc);

    char[] result = new char[sc.length];

    int p = 0;

    for (int m = 0; m < numRows; m++) {
      for (int n = 0; n < width; n++) {
        if (zigzag[m][n] != 0) {
          result[p++] = zigzag[m][n];
        }
      }
    }
    return String.valueOf(result);
  }

  private void a(char[][] zigzag, int width, int numRows, char[] sc) {
    int index = 0;
    for (int j = 0; j < width; j++) {
      for (int i = 0; i < numRows; i++) {
        zigzag[i][j] = sc[index++];
        if (index == sc.length)
          return;
      }
      j++;
      for (int i = numRows - 2; i > 0; i--) {
        zigzag[i][j] = sc[index++];
        if (index == sc.length)
          return;
      }
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P6ZigZagConversion p = new P6ZigZagConversion();
    
    Assert.assertEquals("ACB", p.convert("ABC", 2));
    Assert.assertEquals("", p.convert("", 1));
    Assert.assertEquals(p.convert("A", 2), "A");
    Assert.assertEquals(p.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
    Assert.assertEquals(p.convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
  }

}

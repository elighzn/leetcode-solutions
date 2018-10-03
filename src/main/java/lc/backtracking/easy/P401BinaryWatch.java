package lc.backtracking.easy;

import java.util.List;
import java.util.Vector;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the
 * bottom represent the minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the right.
 * 
 * 8 4 2 1
 * 
 * 0 0 1 1
 * 
 * 0 1 1 0 0 1
 * 
 * 32 16 8 4 2 1
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return
 * all possible times the watch could represent.
 * 
 * Example:
 * 
 * Input: n = 1
 * 
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * 
 * Note:
 * 
 * The order of output does not matter.
 * 
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * 
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is
 * not valid, it should be "10:02".
 */
public class P401BinaryWatch {

  private static final int[] HOURS = {1, 2, 4, 8};
  private static final int[] MINUTES = {1, 2, 4, 8, 16, 32};

  public List<String> readBinaryWatch(int num) {
    List<String> ans = new Vector<>();

    readWatch(ans, num, 0, 0, 0, 0);

    return ans;
  }

  void readWatch(List<String> ans, int num, int hr, int min, int iH, int iM) {

    if (hr > 11 || min > 59)
      return;

    if (num == 0) {
      String a = hr + ":";
      a += min < 10 ? "0" + min : min;
      ans.add(a);
    }

    num--;

    for (; iH < HOURS.length; iH++) {
      readWatch(ans, num, hr + HOURS[iH], min, iH + 1, iM);
    }

    for (; iM < MINUTES.length; iM++) {
      readWatch(ans, num, hr, min + MINUTES[iM], iH, iM + 1);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    P401BinaryWatch p = new P401BinaryWatch();
    System.out.println(p.readBinaryWatch(1));
    System.out.println(p.readBinaryWatch(2));
  }

}

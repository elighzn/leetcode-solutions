package lc.easy;

import org.junit.Assert;

public class P201IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {

    final int L = 256;
    char[] sMap = new char[L];
    char[] tMap = new char[L];
    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();

    for (int i = 0; i < sArr.length; i++) {
      char sc = sArr[i];
      char tc = tArr[i];
      if (sMap[sc] == 0 && tMap[tc] == 0) {
        sMap[sc] = tc;
        tMap[tc] = sc;
      } else if (sMap[sc] != tc || tMap[tc] != sc)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    P201IsomorphicStrings p = new P201IsomorphicStrings();
    Assert.assertEquals(true, p.isIsomorphic("ab", "ca"));
    Assert.assertEquals(true, p.isIsomorphic("egg", "add"));
    Assert.assertEquals(false, p.isIsomorphic("ab", "aa"));
    Assert.assertEquals(false, p.isIsomorphic("foo", "bar"));
    Assert.assertEquals(true, p.isIsomorphic("13", "42"));
  }

}

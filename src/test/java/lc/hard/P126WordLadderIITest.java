package lc.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class P126WordLadderIITest {

  P126WordLadderII p;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {
    p = new P126WordLadderII();

  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testFindLadders() {

//    assert getLadderSolution(p, "red", "tax",
//        new String[] {"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"})
//            .equals("[[red, ted, tex, tax], [red, ted, tad, tax], [red, rex, tex, tax]]");
//    assert getLadderSolution(p, "hot", "dog",
//        new String[] {"hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"})
//            .equals("[[hot, hog, cog, dog], [hot, pot, tot, dot]]");
    
    System.out.println(getLadderSolution(p, "hit", "hot",
        new String[] {"hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"})
            .equals("[[red, ted, tex, tax], [red, ted, tad, tax], [red, rex, tex, tax]]"));
    assert getLadderSolution(p, "hit", "hot",
        new String[] {"hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"})
            .equals("[[red, ted, tex, tax], [red, ted, tad, tax], [red, rex, tex, tax]]");
  }

  @Test
  public void testIsTransformable() {
    assert P126WordLadderII.isTransformable("hot", "tot");
    assert P126WordLadderII.isTransformable("hot", "hop");
    assert !P126WordLadderII.isTransformable("hot", "cog");
    assert !P126WordLadderII.isTransformable("hop", "pot");
    assert P126WordLadderII.isTransformable("hot", "hot");
  }

  private static String getLadderSolution(P126WordLadderII p, String beginWord, String endWord,
      String[] words) {
    return p.findLadders(beginWord, endWord, Arrays.asList(words)).toString();
  }

}

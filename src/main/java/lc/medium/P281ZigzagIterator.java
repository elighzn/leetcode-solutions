package lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/*
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * 
 * Example:
 * 
 * Input: v1 = [1,2] v2 = [3,4,5,6]
 * 
 * Output: [1,3,2,4,5,6]
 * 
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,3,2,4,5,6]. Follow up: What if you are given k 1d vectors? How
 * well can your code be extended to such cases?
 * 
 * Clarification for the follow up question: The "Zigzag" order is not clearly defined and is
 * ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with
 * "Cyclic". For example:
 * 
 * Input: [1,2,3] [4,5,6,7] [8,9]
 * 
 * Output: [1,4,8,2,5,9,3,6,7].
 */

public class P281ZigzagIterator {



  private Queue<Integer> queue;

  public P281ZigzagIterator(List<Integer>... vll) {
    queue = new LinkedList<>();
    List<Iterator<Integer>> itList = new ArrayList<>();
    for (List<Integer> vl : vll) {
      itList.add(vl.iterator());
    }

    while (!itList.isEmpty()) {
      Iterator<Iterator<Integer>> itit = itList.iterator();
      while (itit.hasNext()) {
        Iterator<Integer> it = itit.next();
        if (it.hasNext())
          queue.add(it.next());
        else
          itit.remove();
      }
    }
  }

  public int next() {
    try {
      return queue.poll().intValue();
    } catch (NullPointerException ex) {
      throw new NoSuchElementException();
    }
  }

  public boolean hasNext() {
    return !queue.isEmpty();
  }


  public static List<Integer> toInt(int[] v) {
    return Arrays.stream(v).boxed().collect(Collectors.toList());
  }

  public static void test(List<Integer>... vll) {
    P281ZigzagIterator i = new P281ZigzagIterator(vll);
    StringJoiner sj = new StringJoiner(":", "[", "]");
    while (i.hasNext())
      sj.add(String.valueOf(i.next()));
    System.out.println(sj.toString());
  }

  public static void main(String[] args) {

    /**
     * Your ZigzagIterator object will be instantiated and called as such: ZigzagIterator i = new
     * ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] = i.next();
     */

    test(toInt(new int[] {1, 2}), toInt(new int[] {3, 4, 5, 6}));
    test(toInt(new int[] {1, 2, 3}), toInt(new int[] {4, 5, 6, 7}), toInt(new int[] {8, 9}));
  }

}

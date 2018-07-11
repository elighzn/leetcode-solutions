package lc.google.easy;

import org.junit.Assert;

/**
 * @author zli
 *
 *         Given a stream of integers and a window size, calculate the moving average of all
 *         integers in the sliding window.
 * 
 *         For example, MovingAverage m = new MovingAverage(3); m.next(1) = 1 m.next(10) = (1 + 10)
 *         / 2 m.next(3) = (1 + 10 + 3) / 3 m.next(5) = (10 + 3 + 5) / 3
 */
public class P346MovingAverageFromDataStream {

  class MovingAverage {
    int size;
    Node root = null;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
      this.size = size;
    }

    public double next(int val) {
      Node node = new Node(val);
      node.previous = root;
      root = node;
      int i = 0;
      double total = 0.0;
      
      while (++i <= size && node != null) {
        total += node.val;
        node = node.previous;
      }
      return total / i;
    }
  }

  class Node {
    double val;
    Node previous;

    public Node(int value) {
      this.val = (double) value;
    }
  }

  public void run() {
    MovingAverage ma = new MovingAverage(3);
    Assert.assertEquals(1.0, ma.next(1), 0.0);
    Assert.assertEquals(5.5, ma.next(10), 0.0);
    Assert.assertEquals(4.6667, ma.next(3), 0.001);
    Assert.assertEquals(6, ma.next(5), 0.0001);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P346MovingAverageFromDataStream p = new P346MovingAverageFromDataStream();
    p.run();
  }

}

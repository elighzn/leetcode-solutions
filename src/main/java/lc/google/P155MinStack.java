package lc.google;

import java.util.Stack;
import java.util.StringJoiner;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * top() -- Get the top element.
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * @author zli
 *
 */
public class P155MinStack {

  class Node {
    int minValue;
    int value;

    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public class MinStack {

    private Node top;

    /** initialize your data structure here. */
    public MinStack() {}

    /**
     * Push element x onto stack.
     * 
     * @param x
     */
    public void push(int x) {
      Node node = new Node(x);
        
      
      if (top==null)
        node.minValue = x;
      else
        node.minValue = x < top.minValue ? x : top.minValue;
      
      node.next = top;
      top = node;
    }

    /**
     * Removes the element on top of the stack.
     */
    public void pop() {
      top = top.next;
    }

    /**
     * Get the top element.
     * 
     * @return
     */
    public int top() {
      return top.value;
    }

    /**
     * Retrieve the minimum element in the stack.
     * 
     * @return
     */
    public int getMin() {
      return top.minValue;
    }

    public String toString() {
      Stack<Integer> s = new Stack<>();

      Node node = top;
      while (node != null) {
        s.push(node.value);

        node = node.next;
      }
      StringJoiner sj = new StringJoiner(", ", "[", "]");
      while (!s.isEmpty()) {
        sj.add(s.pop().toString());
      }
      return sj.toString();
    }
  }

  public void run() {
    MinStack ms = new MinStack();
    int[] nums = new int[] {2, 3, 1, -5, 5, 8, 28, 12, 6, 19, -3, 0};

    for (int a : nums) {
      ms.push(a);
    }

    while (ms.top != null) {
      String msg =
          String.format("Pop: %d, min: %d, Stack: %s", ms.top(), ms.getMin(), ms.toString());
      System.out.println(msg);
      ms.pop();
    }

  }

  public void run2() {
    MinStack ms = new MinStack();

    ms.push(-2);
    System.out.println(String.format("%s, min: %d", ms.toString(), ms.getMin()));

    ms.push(0);
    System.out.println(String.format("%s, min: %d", ms.toString(), ms.getMin()));
    ms.push(-3);
    System.out.println(String.format("%s, min: %d", ms.toString(), ms.getMin()));
    ms.getMin();
    ms.pop();
    System.out.println(String.format("%s, min: %d", ms.toString(), ms.getMin()));
    System.out.println(ms.top());
    System.out.println(String.format("%s, min: %d", ms.toString(), ms.getMin()));
    System.out.println(ms.getMin());

  }

  public static void main(String[] args) {
    // TODO Auto-generated methodb
    P155MinStack p = new P155MinStack();
    p.run();
  }

}

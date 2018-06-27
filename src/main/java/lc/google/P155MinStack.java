package lc.google;

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

  public class MinStack {

    private static final int DEFAUT_SIZE = 8;

    private int[] stack;
    private int head;
    private int tail;
    private int minValue;

    /** initialize your data structure here. */
    public MinStack() {
      stack = new int[DEFAUT_SIZE];
      head = 0;
      tail = head;
      minValue = Integer.MAX_VALUE;
    }

    /**
     * Push element x onto stack.
     * 
     * @param x
     */
    public void push(int x) {
      minValue = minValue > x ? x : minValue;
      stack[tail++] = x;
      // double the stack size when full
      if (tail + 1 == stack.length)
        this.resizeStack(stack.length * 2);
    }

    /**
     * Removes the element on top of the stack.
     */
    public void pop() {
      if (head < tail)
        head++;
      else
        throw new RuntimeException("Stack is empty");

      // resize stack to free space
      int n = (int) stack.length / 2;
      if (tail - head < n) {
        this.resizeStack(n);
      }
    }

    /**
     * Get the top element.
     * 
     * @return
     */
    public int top() {
      if (head < tail)
        return stack[head];
      else
        throw new RuntimeException("Stack is empty");
    }

    /**
     * Retrieve the minimum element in the stack.
     * 
     * @return
     */
    public int getMin() {
      return minValue;
    }

    private void resizeStack(int newSize) {
      if (newSize > tail - head) {
        int[] temp = new int[newSize];
        for (int i = head; i <= tail; i++) {
          temp[i - head] = this.stack[i];
        }
        this.stack = temp;
      }
    }

    public String toString() {
      StringJoiner sj = new StringJoiner(", ", "[", "]");
      for (int i = head; i < tail; i++) {
        sj.add(String.valueOf(stack[i]));
      }
      return sj.toString();
    }
  }

  public void run() {
    MinStack ms = new MinStack();
    int[] nums =
        new int[] {2, 3, 1, -5, 5, 8, 28, 12, 6, 19, -3, 0};

    for (int a : nums) {
      ms.push(a);
    }

    while (true) {
      String msg =
          String.format("Pop: %d, min: %d, Stack: %s", ms.top(), ms.getMin(), ms.toString());
      System.out.println(msg);
      ms.pop();
    }

  }

  public static void main(String[] args) {
    // TODO Auto-generated methodb
    P155MinStack p = new P155MinStack();
    p.run();
  }

}

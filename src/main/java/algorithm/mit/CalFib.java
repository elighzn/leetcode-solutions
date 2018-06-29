package algorithm.mit;

import java.util.Hashtable;

public class CalFib {

  Hashtable<Integer, Long> memo;

  public CalFib() {
    memo = new Hashtable<>();
  }

  public long fib(int n) {
    long result = -1;
    if (memo.containsKey(n))
      result = memo.get(n);
    else if (n <= 2) {
      result = 1;
      memo.put(n, result);
    } else {
      result = fib(n - 1) + fib(n - 2);
      memo.put(n, result);
    }
    return result;
  }

  public long fib2(int n) {
    Long result = (long) 1;
    for (int i = 1; i <= n; i++) {
      result = memo.get(i);
      if (result == null) {
        if (i <= 2) {
          result = (long) 1;
          memo.put(i, result);
        } else {
          result = memo.get(i - 1) + memo.get(i - 2);
          memo.put(i, result);
        }
      }
    }
    return result;
  }



  public static void main(String[] args) {
    // TODO Auto-generated method stub
    CalFib cf = new CalFib();
    long fib = 1, pre = 1, pre2 = 1;
    boolean isOverflow = false;
    int n = 1;
    while (!isOverflow) {
      pre2 = pre;
      pre = fib;
      isOverflow = Long.MAX_VALUE - pre < pre2;
      if (!isOverflow) {
        fib = cf.fib2(n);
        double ratio = (double)fib / (double)pre;
        System.out.println(String.format("fib(%d): %d, ratio: %f", n, fib, ratio));
        n++;
      }
    }


    // System.out.println(String.format("fib(%d): %d", 93, cf.fib2(92)));
  }

}

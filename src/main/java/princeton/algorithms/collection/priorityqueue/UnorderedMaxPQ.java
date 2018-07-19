package princeton.algorithms.collection.priorityqueue;

import java.util.NoSuchElementException;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {

  private Key[] pq;
  private int N;


  public UnorderedMaxPQ() {
    this(1);
  }

  @SuppressWarnings("unchecked")
  public UnorderedMaxPQ(int capacity) {
    pq = (Key[]) new Comparable[capacity];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void insert(Key key) {
    if (N == pq.length - 1)
      resize(2 * pq.length);

    pq[N++] = key;
  }

  private void resize(int capacity) {
    @SuppressWarnings("unchecked")
    Key[] copy = (Key[]) new Comparable[capacity];

    for (int i = 0; i <= N; i++)
      copy[i] = pq[i];

    pq = copy;
  }

  public Key delMax() {
    if (isEmpty())
      throw new NoSuchElementException();

    int max = 0;
    for (int i = 1; i < N; i++)
      if (less(max, i))
        max = i;

    exch(max, N - 1);
    Key key = pq[--N];
    pq[N] = null;
    return key;
  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j) {
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
  }

  public static void main(String[] args) {
    UnorderedMaxPQ<String> queue = new UnorderedMaxPQ<String>();
    queue.insert("P");
    queue.insert("R");
    queue.insert("I");
    queue.insert("O");
    queue.insert("R");
    queue.insert("I");
    queue.insert("T");
    queue.insert("Y");
    queue.insert("Q");
    queue.insert("U");
    queue.insert("E");
    queue.insert("U");
    queue.insert("E");


    while (!queue.isEmpty()) {
      System.out.printf("%s ", queue.delMax());
    }

    UnorderedMaxPQ<Integer> queue2 = new UnorderedMaxPQ<Integer>();
    queue2.insert(9);
    queue2.insert(5);
    queue2.insert(7);
    queue2.insert(8);
    queue2.insert(119);
    queue2.insert(3029);
    queue2.insert(1);
    queue2.insert(4);

    while (!queue2.isEmpty()) {
      System.out.printf("%s ", queue2.delMax());
    }

  }

}

package princeton.algorithms.collection.priorityqueue;

import java.util.NoSuchElementException;

public class BinaryHeap<Key extends Comparable<Key>> {
  private Key[] pq;
  private int N;

  public BinaryHeap() {
    this(2);
  }

  @SuppressWarnings("unchecked")
  public BinaryHeap(int capacity) {
    pq = (Key[]) new Comparable[capacity];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void insert(Key key) {
    if (++N >= pq.length)
      resize(2 * N);

    pq[N] = key;

    swim(N);
  }

  public Key delMax() {
    if (isEmpty())
      throw new NoSuchElementException();

    Key max = pq[1];
    exch(1, N--);
    sink(1);
    pq[N + 1] = null;
    return max;
  }

  private void resize(int capacity) {
    @SuppressWarnings("unchecked")
    Key[] copy = (Key[]) new Comparable[capacity];

    for (int i = 0; i < N; i++)
      copy[i] = pq[i];

    pq = copy;
  }

  private void sink(int k) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(j, j + 1))
        j++;
      if (!less(k, j))
        break;
      exch(k, j);
      k = j;
    }
  }

  private void swim(int k) {
    int p = k / 2;
    while (k > 1 && less(p, k)) {
      exch(p, k);
      k = p;
      p = k / 2;
    }
  }

  private boolean less(int i, int j) {
    if (pq[j] == null)
      return false;
    else if (pq[i] == null)
      return true;

    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j) {
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
  }



  public static void main(String[] args) {
    // TODO Auto-generated method stub


    BinaryHeap<Integer> queue2 = new BinaryHeap<Integer>();

    int[] input = new int[] {9, 5, 7, 11, 29, 6, 1, 18, 54, 199, 2818, 293, 2, 4, 2713};

    for (int i : input) {
      System.out.print(i + " ");
      queue2.insert(i);
    }
    System.out.println();

    while (!queue2.isEmpty()) {
      System.out.printf("%s ", queue2.delMax());
    }
  }

}

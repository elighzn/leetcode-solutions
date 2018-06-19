package algorithms.examples;

import java.util.StringJoiner;

public class QuickUnionUF {

  private int[] id;
  private int[] sz;

  public QuickUnionUF(int N) {
    id = new int[N];
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  private int root(int i) {
    while (i != id[i]) {
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (sz[i] < sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }

  }

  public String toString() {
    StringJoiner sj = new StringJoiner(", ", "[", "]");
    for (int i = 0; i < id.length; i++)
      sj.add(String.valueOf(id[i]));
    return sj.toString();
  }

  public static void du(QuickUnionUF auuf, int p, int q) {
    System.out.println(String.format("Union: %d and %d", p, q));
    auuf.union(p, q);
    System.out.println(auuf.toString());
  }

  public static void main(String[] args) {
    int N = 10;
    QuickUnionUF auuf = new QuickUnionUF(N);

    du(auuf, 4, 3);
    du(auuf, 3, 8);
    du(auuf, 6, 5);
    du(auuf, 9, 4);
    du(auuf, 2, 1);
    du(auuf, 5, 0);
    du(auuf, 7, 2);

    du(auuf, 6, 1);
    du(auuf, 5, 0);
    du(auuf, 7, 2);

  }
}

package princeton.algorithms.mst;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import princeton.algorithms.union.QuickUnionUF;

public class MST {

  private Queue<Edge> mst;
  private QuickUnionUF union;

  public MST(EdgeWeightedGraph G) {

    mst = new LinkedList<Edge>();

    PriorityQueue<Edge> pQ = new PriorityQueue<>();
    G.edges().forEach(e -> pQ.add(e));

    union = new QuickUnionUF(G.getNumberOfVertices());

    int N = G.getNumberOfVertices() - 1;
    while (!pQ.isEmpty() && mst.size() < N) {
      Edge e = pQ.poll();
      int v = e.either();
      int w = e.other(v);
      if (!union.connected(v, w)) {
        union.union(v, w);
        mst.add(e);
        System.out.println(union);
        System.out.println(mst);
      }
    }
  }


  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    double weight = 0;
    for (Edge e : mst) {
      weight += e.weight();
    }
    return weight;
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

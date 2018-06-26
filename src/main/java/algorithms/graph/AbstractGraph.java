package algorithms.graph;

import java.util.NoSuchElementException;
import algorithms.collection.Bag;
import algorithms.utils.In;

public abstract class AbstractGraph implements Graph {

  private static final String NEWLINE = System.getProperty("line.separator");

  protected int V;
  protected int E;
  protected Bag<Integer>[] adj;

  public AbstractGraph(int V) {
    if (V < 0)
      throw new IllegalArgumentException("Number of vertices must be nonnegative");
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new Bag<Integer>();
    }
  }

  public AbstractGraph(In in) {
    try {
      this.V = in.readInt();
      if (V < 0)
        throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
      adj = (Bag<Integer>[]) new Bag[V];
      for (int v = 0; v < V; v++) {
        adj[v] = new Bag<Integer>();
      }
      int E = in.readInt();
      if (E < 0)
        throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
      for (int i = 0; i < E; i++) {
        int v = in.readInt();
        int w = in.readInt();
        validateVertex(v);
        validateVertex(w);
        addEdge(v, w);
      }
    } catch (NoSuchElementException e) {
      throw new IllegalArgumentException("invalid input format in Graph constructor", e);
    }
  }

  // throw an IllegalArgumentException unless {@code 0 <= v < V}
  public final void validateVertex(int v) {
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
  }

  /**
   * Returns a string representation of this graph.
   *
   * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>, followed
   *         by the <em>V</em> adjacency lists
   */
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(V + " vertices, " + E + " edges " + NEWLINE);
    for (int v = 0; v < V; v++) {
      s.append(v + ": ");
      for (int w : adj[v]) {
        s.append(w + " ");
      }
      s.append(NEWLINE);
    }
    return s.toString();
  }
}

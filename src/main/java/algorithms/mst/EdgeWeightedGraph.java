package algorithms.mst;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;
import algorithms.collection.Bag;

public class EdgeWeightedGraph {

  private final int numberOfVertices;
  private final Bag<Edge>[] adj;
  private final Set<Edge> set;

  public EdgeWeightedGraph(int numberOfVertices) {
    this.numberOfVertices = numberOfVertices;
    adj = (Bag<Edge>[]) new Bag[numberOfVertices];
    for (int i = 0; i < numberOfVertices; i++) {
      adj[i] = new Bag<>();
    }
    set = new TreeSet<>();
  }

  public void addEdge(Edge e) {
    int v = e.either();
    int w = e.other(v);
    adj[v].add(e);
    adj[w].add(e);
    set.add(e);
  }

  Iterable<Edge> adj(int v) {
    return adj[v];
  }

  Iterable<Edge> edges() {
    Set<Edge> set = new TreeSet<>();
    for (Bag<Edge> bag : adj) {
      for (Edge e : bag) {
        set.add(e);
      }
    }
    return set;
  }

  public int getNumberOfVertices() {
    return this.numberOfVertices;
  }

  public int getNumberOfEdges() {
    return set.size();
  }

  public String toString() {
    StringJoiner sj = new StringJoiner(", ", "{", "}");
    for (Edge e : set) {
      sj.add(e.toString());
    }
    return sj.toString();
  }

  public static void main(String[] args) {
    EdgeWeightedGraph g = new EdgeWeightedGraph(8);
    g.addEdge(new Edge(0, 7, 0.16));
    g.addEdge(new Edge(1, 7, 0.19));
    g.addEdge(new Edge(0, 2, 0.26));
    g.addEdge(new Edge(2, 3, 0.17));
    g.addEdge(new Edge(5, 7, 0.28));
    g.addEdge(new Edge(4, 5, 0.35));
    g.addEdge(new Edge(6, 2, 0.40));
    
    System.out.println(g.toString());
  }
}

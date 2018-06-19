package algorithms.examples.mst;

public class KruskalDemo {

  public static EdgeWeightedGraph constructEWG() {
    EdgeWeightedGraph g = new EdgeWeightedGraph(8);
    g.addEdge(new Edge(0, 7, 0.16));
    g.addEdge(new Edge(2, 3, 0.17));
    g.addEdge(new Edge(1, 7, 0.19));
    g.addEdge(new Edge(0, 2, 0.26));
    g.addEdge(new Edge(5, 7, 0.28));
    g.addEdge(new Edge(1, 3, 0.29));
    g.addEdge(new Edge(1, 5, 0.32));
    g.addEdge(new Edge(2, 7, 0.34));
    g.addEdge(new Edge(4, 5, 0.35));
    g.addEdge(new Edge(1, 2, 0.36));
    g.addEdge(new Edge(4, 7, 0.37));
    g.addEdge(new Edge(0, 4, 0.38));
    g.addEdge(new Edge(6, 2, 0.40));
    g.addEdge(new Edge(3, 6, 0.52));
    g.addEdge(new Edge(6, 0, 0.58));
    g.addEdge(new Edge(6, 4, 0.93));
    return g;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MST mst = new MST(constructEWG());
    System.out.println(mst.weight());
  }

}

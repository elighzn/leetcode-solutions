package algorithms.examples.mst;

public class Edge implements Comparable<Edge> {
  private final int vertexW;
  private final int vertexV;
  private final double weight;

  /**
   * Create an immutable Edge object.
   * 
   * @param v One connecting node
   * @param w The other connecting node
   * @param weight The assigned weight of this edge
   */
  public Edge(int v, int w, double weight) {
    this.vertexV = v;
    this.vertexW = w;
    this.weight = weight;
  }

  /**
   * Return one of the two connecting nodes.
   * 
   * @return One of the two connecting node
   */
  public int either() {
    return vertexV;
  }

  /**
   * Get the other connecting node to the given one.
   * 
   * @param vertex One of the connecting node pair
   * @return The other connecting node of the pair
   */
  public int other(int vertex) {
    if (vertex == vertexV) {
      return vertexW;
    } else {
      return vertexV;
    }

  }

  @Override
  public int compareTo(Edge other) {
    if (weight < other.weight()) {
      return -1;
    } else if (weight > other.weight()) {
      return 1;
    } else {
      return 0;
    }
  }

  public double weight() {
    return this.weight;
  }

  public String toString() {
    return String.format("[%d-%d, %f]", vertexW, vertexV, weight);
  }
}

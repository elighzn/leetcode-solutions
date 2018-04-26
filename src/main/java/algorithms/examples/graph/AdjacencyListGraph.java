package algorithms.examples.graph;

import algorithms.examples.collection.Bag;
import algorithms.examples.utils.In;

public class AdjacencyListGraph extends AbstractGraph {

	private Bag<Integer>[] adj;

	public AdjacencyListGraph(int V) {
		super(V);
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}

	public AdjacencyListGraph(In in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	@Override
	public int V() {
		// TODO Auto-generated method stub
		return this.V;
	}

	@Override
	public int E() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

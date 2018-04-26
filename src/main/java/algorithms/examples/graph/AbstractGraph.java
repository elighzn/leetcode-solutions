package algorithms.examples.graph;

import algorithms.examples.utils.In;

public abstract class AbstractGraph implements Graph {
	protected int V;
	
	public AbstractGraph(int V) {
		this.V = V;
	}

	public AbstractGraph(In in) {
	}
}

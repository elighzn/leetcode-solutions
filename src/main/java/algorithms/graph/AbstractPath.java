package algorithms.graph;

public abstract class AbstractPath implements Paths {

	protected final Graph G;
	protected final int s;

	AbstractPath(Graph G, int s) {
		this.G = G;
		this.s = s;
	}

}

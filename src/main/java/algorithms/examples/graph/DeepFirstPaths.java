package algorithms.examples.graph;

public class DeepFirstPaths extends AbstractPath {

	private boolean[] marked = null;
	private int[] edgeTo = null;
	
	public DeepFirstPaths(Graph G, int s) {
		super(G, s);
	}

	@Override
	public boolean hasPathTo(int v) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked[s] = true;		
		return hasPathTo(s, v);
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean hasPathTo(int currentV, int destV) {
		boolean result = false;
		
		for (int v : G.adj(currentV)) {
			if (!marked[v]) {
				if (v == destV) {
					result = true;
					break;
				} else {
					marked[v] = true;
					edgeTo[v] = currentV;
					result = hasPathTo(v, destV);
				}
			}	
		}
		return result;
	}

}

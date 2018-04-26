package algorithms.examples.graph;

import java.util.Arrays;

import algorithms.examples.utils.StdIn;
import algorithms.examples.utils.StdOut;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int E = 0;
		Graph graph = null;
		while (!StdIn.isEmpty() && StdIn.hasNextLine()) {
			String line = StdIn.readLine();
			StdOut.println(line);
			if (!line.isEmpty()) {
				i++;
				if (i == 1) {
					int V = Integer.parseInt(line);
					graph = new AdjacencyListGraph(V);
				} else if (i == 2) {
					E = Integer.parseInt(line);
				} else {
					String[] s = line.split("\\s|\\t");
					graph.addEdge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				}
			}
		}

		StdOut.println("Over");
	}
}

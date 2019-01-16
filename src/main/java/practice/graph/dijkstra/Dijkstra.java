package practice.graph.dijkstra;

import java.util.Arrays;

public class Dijkstra {

	// A utility function to find the vertex with minimum distance value,
	// from the set of vertices not yet included in shortest path tree
	int minDistance(int[] dist, boolean[] visited) {
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int v = 0; v < dist.length; v++) {
			if (!visited[v] && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	void printSolution(int[] dist, int n) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i + " tt " + dist[i]);
	}

	/**
	 * Funtion that implements Dijkstra's single source shortest path algorithm for
	 * a graph represented using adjacency matrix representation.
	 * 
	 * @param graph
	 * @param src
	 */
	void dijkstra(int[][] graph, int src) {

		final int V = graph.length;
		if (src < 0 || src >= V)
			return;

		// The output array. dist[i] will hold the shortest distance from src to i
		int distances[] = new int[V];

		// visited[i] will true if vertex i is included in shortest path tree or
		// shortest distance from src to i is finalized
		boolean[] visited = new boolean[V];

		Arrays.fill(distances, Integer.MAX_VALUE);

		distances[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices not yet processed.
			// u is always equal to src in first iteration.
			int u = minDistance(distances, visited);

			// Mark the picked vertex as processed
			visited[u] = true;

			// Update distances value of the adjacent vertices of the picked vertex.
			for (int v = 0; v < V; v++) {
				// Update distances[v] only if is not in sptSet, there is an edge from u to v, and
				// total weight of path from src to v through u is smaller than current value of
				// distances[v]
				if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
					int d = distances[u] + graph[u][v];
					if (distances[v] > d)
						distances[v] = d;
				}
			}
		}

		printSolution(distances, V);
	}

	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
		// formatter off
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		// formatter on
		Dijkstra t = new Dijkstra();
		t.dijkstra(graph, 6);
	}

}

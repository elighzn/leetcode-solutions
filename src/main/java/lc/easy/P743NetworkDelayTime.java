package lc.easy;

public class P743NetworkDelayTime {

	public int networkDelayTime(int[][] times, int N, int K) {
		int[][] g = new int[N][N];
		for (int[] t : times) {
			g[t[0] - 1][t[1] - 1] = t[2];
			g[t[1] - 1][t[0] - 1] = t[2];
		}

		return dijkstra(g, N - 1, K - 1);
	}

	public int dijkstra(int[][] graph, int V, int src) {

		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		sptSet[src] = true;

		for (int i = 0; i < V; i++) {
			int u = helper(dist, sptSet);

			sptSet[u] = true;

			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		int max = -1;
		for (int i = 0; i < dist.length; i++) {
			if (i == src)
				continue;

			if (dist[i] == 0)
				return -1;

			if (dist[i] > max)
				max = dist[i];

		}
		return max;
	}

	int helper(int[] dists, boolean[] sptSet) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for (int v = 0; v < dists.length; v++) {
			if (!sptSet[v] && dists[v] < min) {
				min = dists[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

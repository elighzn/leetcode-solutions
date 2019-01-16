package practice.graph.bsf;

public class XTotalShapes {

	public int totalShape(char[][] matrix) {
		if (matrix == null || matrix.length < 1)
			return 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		int ans = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'X' && !visited[i][j]) {
					ans++;
					bfs(visited, matrix, i, j);
				}
			}
		}
		return ans;
	}

	void bfs(boolean[][] visited, char[][] m, int i, int j) {
		int n = 0;
		if (i < 0 || i >= m.length || j < 0 || j >= m[i].length || visited[i][j] || m[i][j] != 'X')
			return;

		visited[i][j] = true;
		bfs(visited, m, i - 1, j);
		bfs(visited, m, i + 1, j);
		bfs(visited, m, i, j - 1);
		bfs(visited, m, i, j + 1);

		return;
	}

	public static char[][] getA(String[] strs) {
		char[][] cArrays = new char[strs.length][strs[0].length()];
		for (int i = 0; i < cArrays.length; i++) {
			cArrays[i] = strs[i].toCharArray();
		}
		return cArrays;
	}

	public static void main(String[] args) {
		XTotalShapes p = new XTotalShapes();
		System.out.println(p.totalShape(getA(new String[] { "OOOXOOO", "OXXXXXO", "OXOOOXO" })));
		System.out.println(p.totalShape(getA(new String[] { "XXX", "OOO", "XXX" })));
	}

}

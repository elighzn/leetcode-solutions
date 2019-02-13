import java.util.Arrays;

public class P149 {

	static class Solution {
		public int maxPoints(Point[] points) {
			if (points == null || points.length == 0)
				return 0;
			final int N = points.length;
			// List<Line> lines = new ArrayList<>();
			Line[] lines = new Line[N * (N - 1) / 2];
			int p = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					// lines.add(new Line(points[i], points[j]));
					lines[p++] = new Line(points[i], points[j]);
				}
			}
			DSU dsu = new DSU(lines);
			return dsu.getNumberOfUnions();
		}

		class DSU {

			int[] parent;

			DSU(Line[] ls) {
				parent = new int[ls.length];
				for (int i = 0; i < parent.length; i++)
					parent[i] = i;

				for (int i = 0; i < ls.length; i++)
					for (int j = 0; j < ls.length; j++) {
						Line l1 = ls[i];
						Line l2 = ls[j];
						if (l1.equals(l2))
							union(i, j);
					}
			}

			int find(int x) {
				if (parent[x] == x) {
					return x;
				}
				parent[x] = find(parent[x]);
				return parent[x];
			}

			void union(int x, int y) {
				int p1 = find(x);
				int p2 = find(x);
				if (p1 != p2)
					parent[p1] = p2;
			}

			int getNumberOfUnions() {
				int num = 0;
				for (int i : parent)
					if (i == -1)
						num++;
				return num;
			}
		}

		class Line {
			Double k = null, b = null;

			Line(Point p1, Point p2) {
				if (p2.x != p1.x) {
					k = ((double) (p2.y - p1.y)) / (p2.x - p1.x);
					b = p1.y - k * p1.x;
				} else {
					b = (double) p1.x;
				}
			}

			boolean equals(Line o) {
				if (k == o.k && b == o.b)
					return true;
				else if (k == null || o.k == null)
					return false;
				return Math.abs(k - o.k) < 0.001 && Math.abs(b - o.b) < 0.001;
			}
		}

	}

	/**
	 * Definition for a point. class Point { int x; int y; Point() { x = 0; y = 0; }
	 * Point(int a, int b) { x = a; y = b; } }
	 */
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.print(s.maxPoints(new Point[] { new Point(1, 1), new Point(2, 2), new Point(1, 2) }));
	}

}

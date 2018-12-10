package lc.pinterest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P505MazeII {

	private static int[][] DIRS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public int shortestDistance(int[][] maze, int[] start, int[] dest) {
		return shortestDistance1(maze, start, dest);
		// return shortestDistance2(maze, start, dest);
	}

	public int shortestDistance1(int[][] maze, int[] start, int[] dest) {
		int[][] distance = new int[maze.length][maze[0].length];
		for (int[] row : distance)
			Arrays.fill(row, Integer.MAX_VALUE);
		distance[start[0]][start[1]] = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Arrays.stream(distance).forEach(d->System.out.println(Arrays.toString(d)));
			System.out.println("=========================================");
			int[] s = queue.poll();
			for (int[] dir : DIRS) {
				int x = s[0] + dir[0];
				int y = s[1] + dir[1];
				int count = 0;
				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
					count++;
				}
				if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
					distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
					queue.add(new int[] { x - dir[0], y - dir[1] });
				}
			}
		}
		return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	}

	public int shortestDistance2(int[][] maze, int[] start, int[] dest) {
		int[][] distance = new int[maze.length][maze[0].length];
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		for (int[] row : distance)
			Arrays.fill(row, Integer.MAX_VALUE);
		distance[start[0]][start[1]] = 0;
		dijkstra(maze, distance, visited);
		return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	}

	public int[] minDistance(int[][] distance, boolean[][] visited) {
		int[] min = { -1, -1 };
		int min_val = Integer.MAX_VALUE;
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[0].length; j++) {
				if (!visited[i][j] && distance[i][j] < min_val) {
					min = new int[] { i, j };
					min_val = distance[i][j];
				}
			}
		}
		return min;
	}

	public void dijkstra(int[][] maze, int[][] distance, boolean[][] visited) {
		while (true) {
			int[] s = minDistance(distance, visited);
			if (s[0] < 0)
				break;
			visited[s[0]][s[1]] = true;
			for (int[] dir : DIRS) {
				int x = s[0] + dir[0];
				int y = s[1] + dir[1];
				int count = 0;
				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
					count++;
				}
				if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
					distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
				}
			}
		}
	}

	public void dijkstra2(int[][] maze, int[] start, int[][] distance) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});
		queue.offer(new int[] { start[0], start[1], 0 });
		while (!queue.isEmpty()) {
			int[] s = queue.poll();
			if (distance[s[0]][s[1]] < s[2])
				continue;
			for (int[] dir : DIRS) {

			}
		}
	}

	public static void main(String[] args) {
		P505MazeII p = new P505MazeII();
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] dest = { 4, 4 };
		System.out.println(p.shortestDistance(maze, start, dest));
	}

}

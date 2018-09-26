package lc.facebook.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zli You are given a map in form of a two-dimensional integer grid
 *         where 1 represents land and 0 represents water. Grid cells are
 *         connected horizontally/vertically (not diagonally). The grid is
 *         completely surrounded by water, and there is exactly one island
 *         (i.e., one or more connected land cells). The island doesn't have
 *         "lakes" (water inside that isn't connected to the water around the
 *         island). One cell is a square with side length 1. The grid is
 *         rectangular, width and height don't exceed 100. Determine the
 *         perimeter of the island.
 */
public class P463IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int ans = 0;
		
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1)
					ans += getCellPerimeter(grid, i, j);
			}

		return ans;
	}

	int getCellPerimeter(int[][] grid, int row, int col) {

		int ans = 0;

		ans += isCellWater(grid, row - 1, col) ? 1 : 0;
		ans += isCellWater(grid, row + 1, col) ? 1 : 0;
		ans += isCellWater(grid, row, col - 1) ? 1 : 0;
		ans += isCellWater(grid, row, col + 1) ? 1 : 0;

		return ans;
	}

	boolean isCellWater(int[][] grid, int row, int col) {
		return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0;
	}

	public static void main(String[] args) {
		P463IslandPerimeter p = new P463IslandPerimeter();
		int[][] island = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

		assertEquals(3, p.getCellPerimeter(island, 0, 1));
		assertEquals(3, p.getCellPerimeter(island, 1, 0));

		assertEquals(16, p.islandPerimeter(island));
	}

}

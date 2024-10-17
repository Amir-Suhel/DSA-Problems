package com.dynamic.progrmming.DP3D;

public class CherryPickupByBackTrackingLeetCode {
	static int maxi = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
		cp1(0, 0, 0, grid);
		System.out.println("ans: " + maxi);

	}

	private static void cp1(int row, int col, int sum, int[][] grid) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1)
			return;

		if (row == grid.length - 1 && col == grid[0].length - 1) {
			helper(row, col, sum, grid);
		}

		int cherry = grid[row][col];
		grid[row][col] = 0;
		cp1(row + 1, col, sum + cherry, grid);
		cp1(row, col + 1, sum + cherry, grid);
		grid[row][col] = cherry;

	}

	private static void helper(int row, int col, int sum, int[][] grid) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1)
			return;

		if (row == 0 && col == 0) {
			maxi = Math.max(maxi, sum);
			return;
		}

		int cherry = grid[row][col];
		grid[row][col] = 0;
		helper(row - 1, col, sum + cherry, grid);
		helper(row, col - 1, sum + cherry, grid);
		grid[row][col] = cherry;
	}

}

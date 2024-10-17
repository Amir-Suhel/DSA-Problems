package com.dynamic.progrmming.DP2D;

import java.util.Arrays;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
		int m = grid.length;
		int n = grid[0].length;

		System.out.println("recursive: " + solve(m - 1, n - 1, grid));
		int[][] dp = new int[m][n];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);
		System.out.println("memoization: " + memo(m - 1, n - 1, dp, grid));
		System.out.println("tabulation: " + tabulation(m, n, grid));
	}

	private static int solve(int row, int col, int[][] grid) {
		if (row == 0 && col == 0)
			return grid[0][0];
		if (row < 0 || col < 0)
			return (int) Math.pow(10, 5);

		return Math.min(grid[row][col] + solve(row - 1, col, grid), grid[row][col] + solve(row, col - 1, grid));
	}

	private static int memo(int row, int col, int[][] dp, int[][] grid) {
		if (row == 0 && col == 0)
			return grid[0][0];
		if (row < 0 || col < 0)
			return (int) Math.pow(10, 5);

		if (dp[row][col] != -1)
			return dp[row][col];

		return dp[row][col] = Math.min(grid[row][col] + memo(row - 1, col, dp, grid),
				grid[row][col] + memo(row, col - 1, dp, grid));
	}

	private static int tabulation(int m, int n, int[][] grid) {
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				else {
					int up = grid[i][j];
					if (i > 0) {
						up += dp[i - 1][j];
					} else
						up += (int) Math.pow(10, 5);
					int left = grid[i][j];
					if (j > 0) {
						left += dp[i][j - 1];
					} else
						left += (int) Math.pow(10, 5);
					dp[i][j] = Math.min(up, left);

				}

			}
		}
		return dp[m - 1][n - 1];
	}

}

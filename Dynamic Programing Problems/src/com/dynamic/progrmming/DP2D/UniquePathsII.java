package com.dynamic.progrmming.DP2D;

import java.util.Arrays;

public class UniquePathsII {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int m = grid.length;
		int n = grid[0].length;

		System.out.println("recursive:" + solve(m - 1, n - 1, grid));

		int[][] dp = new int[m][n];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);
		System.out.println("memoization: " + memo(m - 1, n - 1, dp, grid));
		System.out.println("tabulation: " + tabulation(m, n, grid));

	}

	private static int solve(int row, int col, int[][] grid) {
		if (row == 0 && col == 0)
			return 1;
		if (row < 0 || col < 0 || grid[row][col] == 1)
			return 0;

		return solve(row - 1, col, grid) + solve(row, col - 1, grid);
	}

	private static int memo(int row, int col, int[][] dp, int[][] grid) {
		if (row == 0 && col == 0)
			return 1;
		if (row < 0 || col < 0 || grid[row][col] == 1)
			return 0;
		if (dp[row][col] != -1)
			return dp[row][col];

		return dp[row][col] = solve(row - 1, col, grid) + solve(row, col - 1, grid);
	}
	
	private static int tabulation(int m, int n, int[][] grid) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && j == 0) continue;
				int up = 0;
				int left = 0;
				if(i > 0 && grid[i][j] == 0) {
					up = dp[i-1][j];
				}
				if(j > 0 && grid[i][j] == 0) {
					left = dp[i][j-1];
				}
				
				dp[i][j] = up + left;
			}
		}
		return dp[m-1][n-1];
	}
}

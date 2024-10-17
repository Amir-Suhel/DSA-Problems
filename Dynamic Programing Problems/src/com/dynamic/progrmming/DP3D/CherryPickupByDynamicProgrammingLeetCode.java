package com.dynamic.progrmming.DP3D;

public class CherryPickupByDynamicProgrammingLeetCode {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
		int n = grid.length;

		int[][][][] dp = new int[n][n][n][n];
		System.out.println("solution: " + solve(0, 0, 0, 0, n, grid, dp));
	}

	public static int solve(int i1, int j1, int i2, int j2, int n, int[][] grid, int[][][][] dp) {
		if (i1 >= n || i2 >= n || j1 >= n || j2 >= n || grid[i1][j1] == -1 || grid[i2][j2] == -1) {
			return Integer.MIN_VALUE;
		}

		if (i1 == n - 1 && j1 == n - 1) {
			return grid[i1][j1];
		}

		if (dp[i1][j1][i2][j2] != 0)
			return dp[i1][j1][i2][j2];

		int cherry = 0;
		if (i1 == i2 && j1 == j2) {
			cherry += grid[i1][j1];
		} else {
			cherry += grid[i1][j1] + grid[i2][j2];
		}
		int f1 = solve(i1, j1 + 1, i2, j2 + 1, n, grid, dp); // HH
		int f2 = solve(i1, j1 + 1, i2 + 1, j2, n, grid, dp); // HV
		int f3 = solve(i1 + 1, j1, i2, j2 + 1, n, grid, dp); // VH
		int f4 = solve(i1 + 1, j1, i2 + 1, j2, n, grid, dp); // VV

		cherry += Math.max(Math.max(f1, f2), Math.max(f3, f4));

		return dp[i1][j1][i2][j2] = cherry;
	}
}

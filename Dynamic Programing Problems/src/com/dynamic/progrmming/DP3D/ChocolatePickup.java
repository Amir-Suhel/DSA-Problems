package com.dynamic.progrmming.DP3D;

import java.util.Arrays;

public class ChocolatePickup {

	static int mod = (int) Math.pow(10, -9);

	public static void main(String[] args) {
		int[][] grid = { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 3, 5 } };
		int r = grid.length;
		int c = grid[0].length;

		System.out.println("soln: " + maximumChocolates(r, c, grid));

	}

	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[r][c][c];
		for (int[][] arr : dp) {
			for (int[] row : arr) {
				Arrays.fill(row, -1);
			}
		}
		return solve(0, 0, c - 1, r, c, grid, dp);
	}

	public static int solve(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
		if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
			return mod;

		if (i == r - 1) {
			if (j1 == j2)
				return grid[i][j1];
			else
				return grid[i][j1] + grid[i][j2];
		}
		if (dp[i][j1][j2] != -1)
			return dp[i][j1][j2];
		int maxi = 0;
		for (int dj1 = -1; dj1 <= 1; dj1++) {
			for (int dj2 = -1; dj2 <= 1; dj2++) {
				if (j1 == j2)
					maxi = Math.max(maxi, grid[i][j1] + solve(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp));
				else
					maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + solve(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp));
			}
		}

		return dp[i][j1][j2] = maxi;
	}

}

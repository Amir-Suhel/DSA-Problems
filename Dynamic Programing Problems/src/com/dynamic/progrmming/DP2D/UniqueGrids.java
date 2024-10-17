package com.dynamic.progrmming.DP2D;

import java.util.Arrays;

public class UniqueGrids {

	public static void main(String[] args) {
		int m = 3;
		int n = 7;

		System.out.println("recursive: " + recursive(m - 1, n - 1));

		int[][] dp = new int[m][n];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		System.out.println("memoization: " + memo(m - 1, n - 1, dp));
		System.out.println("tabulation: " + tabulation(m, n));
		System.out.println("optimised: " + optimised(m, n));

	}

	private static int recursive(int row, int col) {
		if (row == 0 && col == 0)
			return 1;
		if (row < 0 || col < 0)
			return 0;

		return recursive(row - 1, col) + recursive(row, col - 1);
	}

	private static int memo(int row, int col, int[][] dp) {
		if (row == 0 && col == 0)
			return 1;
		if (row < 0 || col < 0)
			return 0;
		if (dp[row][col] != -1)
			return dp[row][col];

		return dp[row][col] = memo(row - 1, col, dp) + memo(row, col - 1, dp);
	}

	private static int tabulation(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				int up = 0;
				int left = 0;
				if (i > 0) {
					up = dp[i - 1][j];
				}
				if (j > 0) {
					left = dp[i][j - 1];
				}

				dp[i][j] = up + left;
			}

		}

		return dp[m - 1][n - 1];
	}

	private static int optimised(int m, int n) {
		int prev[] = new int[n];

		for (int i = 0; i < m; i++) {
			// Create a temporary array to store the results for the current row
			int temp[] = new int[n];

			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					// Base condition: There's one way to reach the top-left cell (0, 0)
					temp[j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				// Calculate the number of ways by moving up (if possible) and left (if
				// possible)
				if (i > 0)
					up = prev[j];
				if (j > 0)
					left = temp[j - 1];

				// Store the total number of ways to reach the current cell in the temporary
				// array
				temp[j] = up + left;
			}

			// Set the temporary array as the previous array for the next row
			prev = temp;
		}

		// Return the number of ways to reach the bottom-right cell (m-1, n-1)
		return prev[n - 1];
	}

}

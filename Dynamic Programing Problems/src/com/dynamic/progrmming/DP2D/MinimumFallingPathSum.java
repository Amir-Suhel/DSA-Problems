package com.dynamic.progrmming.DP2D;

import java.util.Arrays;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		int m = matrix.length;
		int n = matrix[0].length;
		int mini = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			mini = Math.min(mini, solve(0, i, matrix));
		}
		System.out.println("recursive: " + mini);
		int[][] dp = new int[m][n];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);
		int mini1 = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			mini1 = Math.min(mini1, memo(0, i, dp, matrix));
		}
		System.out.println("memoization: " + mini1);

		System.out.println("tabulation: " + tabulation(matrix));
	}

	private static int solve(int row, int col, int[][] matrix) {
		if (col < 0 || col >= matrix[0].length)
			return (int) Math.pow(10, 9);

		if (row == matrix.length - 1)
			return matrix[row][col];

		int left = solve(row + 1, col - 1, matrix);
		int down = solve(row + 1, col, matrix);
		int right = solve(row + 1, col + 1, matrix);

		return matrix[row][col] + Math.min(down, Math.min(left, right));
	}

	private static int memo(int row, int col, int[][] dp, int[][] matrix) {
		if (col < 0 || col >= matrix[0].length)
			return (int) Math.pow(10, 9);

		if (row == matrix.length - 1)
			return matrix[row][col];

		if (dp[row][col] != -1)
			return dp[row][col];

		int left = memo(row + 1, col - 1, dp, matrix);
		int down = memo(row + 1, col, dp, matrix);
		int right = memo(row + 1, col + 1, dp, matrix);

		return dp[row][col] = matrix[row][col] + Math.min(down, Math.min(left, right));
	}

	private static int tabulation(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows][cols];

		// Initializing dp array with values from the last row of the matrix
		for (int i = 0; i < cols; i++) {
			dp[rows - 1][i] = matrix[rows - 1][i];
		}

		// Bottom-up computation
		for (int i = rows - 2; i >= 0; i--) {
			for (int j = 0; j < cols; j++) {
				// Handling boundary conditions for columns
				int left = (j > 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
				int down = dp[i + 1][j];
				int right = (j < cols - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

				// Calculating minimum path sum
				dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
			}
		}

		// Finding the minimum path sum from the top row
		int minPathSum = Integer.MAX_VALUE;
		for (int i = 0; i < cols; i++) {
			minPathSum = Math.min(minPathSum, dp[0][i]);
		}

		return minPathSum;
	}

}

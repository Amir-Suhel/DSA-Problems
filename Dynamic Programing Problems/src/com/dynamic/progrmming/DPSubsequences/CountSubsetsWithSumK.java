package com.dynamic.progrmming.DPSubsequences;

import java.util.Arrays;

public class CountSubsetsWithSumK {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 1 };
		System.out.println("cnt: " + countSubsetsWithSumK(arr, 1));
		System.out.println("tabulation: " + tabulation(arr, 1));
	}

	private static int countSubsetsWithSumK(int[] arr, int k) {
		int n = arr.length;
		int[][] dp = new int[n][k + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return solve(n - 1, k, arr, dp);
	}

	private static int solve(int idx, int k, int[] arr, int[][] dp) {
		if (idx == 0) {
			if (k == 0 && arr[0] == 0)
				return 2;
			if (k == 0 || arr[0] == k)
				return 1;
			return 0;
		}

		if (dp[idx][k] != -1)
			return dp[idx][k];

		int notTaken = solve(idx - 1, k, arr, dp);
		int taken = 0;
		if (arr[idx] <= k)
			taken = solve(idx - 1, k - arr[idx], arr, dp);

		return dp[idx][k] = taken + notTaken;
	}

	public static int tabulation(int arr[], int target) {
		int n = arr.length;
		int[][] dp = new int[n][target + 1];

		for (int i = 0; i < n; i++)
			dp[i][0] = 1;
		if (arr[0] <= target)
			dp[0][arr[0]] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= target; j++) {
				int notTaken = dp[i - 1][j];
				int taken = 0;
				if (arr[i] <= j)
					taken = dp[i - 1][j - arr[i]];

				dp[i][j] = taken + notTaken;
			}
		}
		return dp[n - 1][target];
	}

}

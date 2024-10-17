package com.dynamic.progrmming;

import java.util.Arrays;

public class FibonacciSeries {

	static int cnt1 = 0;
	static int cnt2 = 0;

	public static void main(String[] args) {
		int n = 5;
//		System.out.println("recursive soln: " + fib(n));
//        System.out.println("memoization soln: " + dynamicProgramming(n));
//		System.out.println("tabulation soln: " +tabulation(n));
//		System.out.println("optimised soln: " + optimisedSoln(n));

		String s = "amir";
		StringBuilder sb = new StringBuilder(s).reverse();
		System.out.println(sb.toString());

	}

	private static int fib(int n) {
		cnt1++;
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

	private static int dynamicProgramming(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return memo(n, dp);
	}

	/**
	 * Memoization
	 */
	private static int memo(int n, int[] dp) {
		cnt2++;

		if (n <= 1) {
			return n;
		}
		if (dp[n] != -1)
			return dp[n];
		return dp[n] = memo(n - 1, dp) + memo(n - 2, dp);
	}

	/**
	 * Tabulation
	 */
	private static int tabulation(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	/**
	 * Optimized Solution
	 */
	public static int optimisedSoln(int n) {
		int prev = 1;
		int prev1 = 0;
		for (int i = 2; i <= n; i++) {
			int curr = prev + prev1;
			prev1 = prev;
			prev = curr;
		}
		return prev;
	}
}

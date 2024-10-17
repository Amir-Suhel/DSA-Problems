package com.dynamic.progrmming;

import java.util.Arrays;

public class HouseRobber {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0 };
		System.out.println(rob(new int[] { 0, 1, 0 }));
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(memo(arr.length - 1, dp, arr));

	}

	public static int rob(int[] nums) {
		int n = nums.length;
		int prev = nums[0];
		int prev1 = 0;
		for (int i = 1; i < n; i++) {
			int pick = nums[i];
			if (i > 1) {
				pick += prev1;
			}
			int notPick = prev;
			prev1 = prev;
			prev = Math.max(pick, notPick);
			System.out.println("prev1: " + prev1 + ", prev: " + prev);
		}
		return prev;

	}

	public static int memo(int idx, int[] dp, int[] nums) {
		if (idx < 0)
			return 0;
		if (idx == 0)
			return nums[idx];
		if (dp[idx] != -1)
			return dp[idx];

		int pick = nums[idx] + memo(idx - 2, dp, nums);
		int notPick = memo(idx - 1, dp, nums);

		return dp[idx] = Math.max(pick, notPick);
	}
}
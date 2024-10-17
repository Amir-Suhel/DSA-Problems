package com.dynamic.progrmming.DPSubsequences;

public class PartitionSetInto2SubsetsWithMinAbsoluteSumDiff {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 8, 1 };

		System.out.println("minimum differnce: " + minimumDifference(nums));

	}

	private static int minimumDifference(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int a : nums)
			sum += a;
		boolean[][] dp = new boolean[n][sum + 1];
		for (int i = 0; i < n; i++)
			dp[i][0] = true;
		if (nums[0] <= sum)
			dp[0][nums[0]] = true;

		for (int idx = 1; idx < n; idx++) {
			for (int target = 1; target <= sum; target++) {
				boolean notTaken = dp[idx - 1][target];
				boolean taken = false;
				if (nums[idx] <= target)
					taken = dp[idx - 1][target - nums[idx]];

				dp[idx][target] = taken || notTaken;
			}
		}

		int mini = Integer.MAX_VALUE;

		for (int j = 0; j <= sum; j++) {
			if (dp[n - 1][j]) {
				mini = Math.min(mini, Math.abs(j - (sum - j)));
			}
		}

		return mini;

	}

	public static int optimised(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int a : nums)
			sum += a;
		boolean[] prev = new boolean[sum + 1];
		prev[0] = true;
		if (nums[0] <= sum)
			prev[nums[0]] = true;

		boolean[] curr = new boolean[sum + 1];
		curr[0] = true;

		for (int idx = 1; idx < n; idx++) {
			for (int target = 1; target <= sum; target++) {
				boolean notTaken = prev[target];
				boolean taken = false;
				if (nums[idx] <= target)
					taken = prev[target - nums[idx]];

				curr[target] = taken || notTaken;
			}
			prev = curr;
		}

		int mini = Integer.MAX_VALUE;

		for (int j = 0; j <= sum; j++) {
			if (prev[j]) {
				mini = Math.min(mini, Math.abs(j - (sum - j)));
			}
		}

		return mini;
	}
}

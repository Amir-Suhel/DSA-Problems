package com.dynamic.progrmming.DP2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPathSumTriangularGrid {

	public static void main(String[] args) {

		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1));
		list.add(Arrays.asList(2, 3));
		list.add(Arrays.asList(3, 6, 7));
		list.add(Arrays.asList(8, 9, 6, 10));

		int ans = solve(0, 0, list);
		System.out.println("recursive: " + ans);

		List<List<Integer>> dp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < list.get(i).size(); j++) {
				row.add(-1);
			}
			dp.add(row);
		}

		System.out.println("memoization: " + memo(0, 0, dp, list));

	}

	private static int solve(int row, int col, List<List<Integer>> list) {
		if (row == list.size() - 1)
			return list.get(row).get(col);

		int down = list.get(row).get(col) + solve(row + 1, col, list);
		int right = list.get(row).get(col) + solve(row + 1, col + 1, list);

		return Math.min(down, right);
	}

	private static int memo(int row, int col, List<List<Integer>> dp, List<List<Integer>> list) {
		if (row == list.size() - 1)
			return list.get(row).get(col);

		if (dp.get(row).get(col) != -1)
			return dp.get(row).get(col);
		int down = list.get(row).get(col) + memo(row + 1, col, dp, list);
		int right = list.get(row).get(col) + memo(row + 1, col + 1, dp, list);
		int mini = Math.min(down, right);
		dp.get(row).set(col, mini);
		return mini;
	}

}

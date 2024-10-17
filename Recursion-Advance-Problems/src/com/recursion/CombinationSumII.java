package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> ans = combinationSum(arr, 8);
		for (List<Integer> list : ans) {
			System.out.println(list);
		}

	}

	private static List<List<Integer>> combinationSum(int[] arr, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		solve(0, target, new ArrayList<>(), arr, ans);
		return ans;
	}

	private static void solve(int idx, int target, List<Integer> list, int[] arr, List<List<Integer>> ans) {
		if (idx == arr.length) {
			if (target == 0 && !ans.contains(new ArrayList<>(list))) {
				ans.add(new ArrayList<>(list));
			}
			return;
		}
		if (arr[idx] <= target) {
			list.add(arr[idx]);
			solve(idx + 1, target - arr[idx], list, arr, ans);
			list.remove(list.size() - 1);
		}
		solve(idx + 1, target, list, arr, ans);

	}
}

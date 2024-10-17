package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesForArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		List<List<Integer>> ans = subsequences(arr);

		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> subsequences(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		solve(0, new ArrayList<>(), arr, ans);
		return ans;
	}

	public static void solve(int idx, List<Integer> list, int[] arr, List<List<Integer>> ans) {
		if (idx == arr.length) {
			ans.add(new ArrayList<>(list));
			return;
		}

		list.add(arr[idx]);
		solve(idx + 1, list, arr, ans);
		list.remove(list.size() - 1);
		solve(idx + 1, list, arr, ans);

	}

}

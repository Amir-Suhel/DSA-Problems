package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		subset(arr).forEach(e -> System.out.println(e));

	}

	public static List<List<Integer>> subset(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		solve1(0, new ArrayList<>(), arr, ans);
		return ans;
	}

	public static void solve1(int idx, List<Integer> ds, int[] arr, List<List<Integer>> ans) {

		ans.add(new ArrayList<>(ds));

		for (int i = idx; i < arr.length; i++) {
			ds.add(arr[i]);
			solve1(i + 1, ds, arr, ans);
			ds.remove(ds.size() - 1);
		}
	}

	public static void solve2(int idx, List<Integer> ds, int[] arr, List<List<Integer>> ans) {
		if (idx == arr.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		ds.add(arr[idx]);
		solve2(idx + 1, ds, arr, ans);
		ds.remove(ds.size() - 1);
		solve2(idx + 1, ds, arr, ans);
	}

}

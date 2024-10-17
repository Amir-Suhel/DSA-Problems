package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueSubsets {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		List<List<Integer>> ans = uniqueSubsets2(arr);
		ans.forEach((e) -> System.out.println(e));

	}

	private static List<List<Integer>> uniqueSubsets2(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		solve2(0, new ArrayList<>(), arr, ans);
		return ans;
	}

	private static void solve2(int idx, List<Integer> ds, int[] arr, List<List<Integer>> ans) {

		ans.add(new ArrayList<>(ds));

		for (int i = idx; i < arr.length; i++) {
			if (i > idx && arr[i] == arr[i - 1])
				continue;
			ds.add(arr[i]);
			solve2(i + 1, ds, arr, ans);
			ds.remove(ds.size() - 1);
		}
	}

	@SuppressWarnings("unused")
	private static Set<List<Integer>> uniqueSubsets1(int[] arr) {
		Set<List<Integer>> ans = new HashSet<>();
		solve1(0, new ArrayList<>(), arr, ans);
		return ans;
	}

	private static void solve1(int idx, List<Integer> ds, int[] arr, Set<List<Integer>> ans) {
		if (idx == arr.length) {
			Collections.sort(ds);
			ans.add(new ArrayList<>(ds));
			return;
		}

		ds.add(arr[idx]);
		solve1(idx + 1, ds, arr, ans);
		ds.remove(ds.size() - 1);
		solve1(idx + 1, ds, arr, ans);

	}

}

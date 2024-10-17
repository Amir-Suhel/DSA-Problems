package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		permutationWithHashing(arr).forEach(e -> System.out.println(e));
//		System.out.println("without hashing: ");
//		permuationWithOptimisedSolution(arr).forEach(e -> System.out.println(e));

	}

	public static List<List<Integer>> permutationWithHashing(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		boolean[] map = new boolean[arr.length];
		solve(map, new ArrayList<Integer>(), arr, ans);
		return ans;
	}

	public static void solve(boolean[] map, List<Integer> ds, int[] arr, List<List<Integer>> ans) {
		if (ds.size() == map.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = 0; i < map.length; i++) {
			if (!map[i]) {
				ds.add(arr[i]);
				map[i] = true;
				solve(map, ds, arr, ans);
				ds.remove(ds.size() - 1);
				map[i] = false;
			}
		}
	}

	public static List<List<Integer>> permuationWithOptimisedSolution(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		solve2(0, arr, ans);
		return ans;
	}

	public static void solve2(int idx, int[] arr, List<List<Integer>> ans) {
		if (idx == arr.length) {
			List<Integer> ds = new ArrayList<>();
			for (int a : arr) {
				ds.add(a);
			}
			ans.add(ds);
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;

			solve2(idx + 1, arr, ans);

			temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;

		}
	}

}

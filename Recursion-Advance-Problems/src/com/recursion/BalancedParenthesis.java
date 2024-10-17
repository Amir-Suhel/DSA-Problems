package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalancedParenthesis {

	public static void main(String[] args) {
		int n = 3;

		List<String> ans = generateParenthesis(n);
		System.out.println(ans);
		List<List<Integer>> ds = new ArrayList<>();
		ds.add(Arrays.asList(1, 2, 3, 4, 5));
		ds.add(Arrays.asList(6, 7, 8, 9));
		List<List<Integer>> list = new ArrayList<>();
		list.add(ds.get(0));
		System.out.println(list);
	}

	private static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		solve(n, n, "", ans);
		return ans;
	}

	private static void solve(int open, int close, String str, List<String> ans) {
		if (open == 0 && close == 0) {
			ans.add(str);
			return;
		}
		if (open > 0) {
			solve(open - 1, close, str + '(', ans);
		}
		if (close > 0) {
			if (close > open) {
				solve(open, close - 1, str + ')', ans);
			}
		}
	}

}

package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		String str = "aabb";
		palindromPartioning(str).forEach(e -> System.out.println(e));
	}

	private static List<List<String>> palindromPartioning(String str) {
		List<List<String>> ans = new ArrayList<>();
		solve(0, str, new ArrayList<String>(), ans);
		return ans;
	}

	private static void solve(int idx, String str, List<String> path, List<List<String>> ans) {
		if (idx == str.length()) {
			ans.add(new ArrayList<>(path));
			return;
		}
		for (int i = idx; i < str.length(); i++) {
			if (isPalindrome(idx, i, str)) {
				path.add(str.substring(idx, i + 1));
				solve(i + 1, str, path, ans);
				path.remove(path.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(int i, int j, String str) {
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}

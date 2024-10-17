package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsequencesForString {

	public static void main(String[] args) {
		String str = "abc";
		List<String> ans = subsequences(str);
		Collections.sort(ans);
		System.out.println(ans);

	}

	public static List<String> subsequences(String str) {
		List<String> ans = new ArrayList<>();
		solve(0, "", str, ans);
		return ans;
	}

	public static void solve(int idx, String s, String str, List<String> ans) {
		if (idx == str.length()) {
			ans.add(s);
			return;
		}
		solve(idx + 1, s + str.charAt(idx), str, ans);
		solve(idx + 1, s, str, ans);
	}

}

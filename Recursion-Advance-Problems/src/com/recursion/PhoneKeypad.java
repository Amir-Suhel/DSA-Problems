package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeypad {

	public static void main(String[] args) {
		String digits = "23";
		System.out.println(letterCombinations(digits));

	}

	public static List<String> letterCombinations(String digits) {

		String[] map = { ",", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> ans = new ArrayList<>();
		if (digits == "")
			return ans;
		solve1(0, new StringBuilder(), map, digits, ans);
		return ans;
	}

	/**
	 * By String but, it will create each time new String, due to this it is taking
	 * more time. Although time complexity is same
	 */
	public static void solve(int idx, String ds, String[] map, String digits, List<String> ans) {
		if (idx == digits.length()) {
			ans.add(ds);
			return;
		}
		int digit = digits.charAt(idx) - '0';
		for (int i = 0; i < map[digit].length(); i++) {
			solve(idx + 1, ds + map[digit].charAt(i), map, digits, ans);
		}

	}

	/**
	 * By StringBuilder,taking less time Although time complexity is same
	 */
	public static void solve1(int idx, StringBuilder ds, String[] map, String digits, List<String> ans) {
		if (idx == digits.length()) {
			ans.add(ds.toString());
			return;
		}
		int digit = digits.charAt(idx) - '0';
		String s = map[digit];

		for (int i = 0; i < s.length(); i++) {
			ds.append(s.charAt(i));
			solve1(idx + 1, ds, map, digits, ans);
			ds.deleteCharAt(ds.length() - 1);
		}
	}
}

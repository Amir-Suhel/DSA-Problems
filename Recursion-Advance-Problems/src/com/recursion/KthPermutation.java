package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

	public static void main(String[] args) {
		int n = 5, k = 51;
		String ans = getPermutation(n, k);
		System.out.println("The Kth permutation sequence is " + ans);

	}

	private static String getPermutation(int n, int k) {
		List<Integer> numbers = new ArrayList<>();
		int fact = 1;
		for (int i = 1; i < n; i++) {
			fact *= i;
			numbers.add(i);
		}
		numbers.add(n);
		String ans = "";
		k = k - 1;
		while (true) {
			ans += numbers.get(k / fact);
			numbers.remove(k / fact);
			if (numbers.isEmpty())
				break;
			fact /= numbers.size();
			k %= fact;
		}
		return ans;
	}

}

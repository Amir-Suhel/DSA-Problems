package com.recursion;

import java.util.ArrayList;

public class NQueen {

	public static void main(String[] args) {
		solveNQueens(4).forEach(e -> System.out.println(e));

	}

	public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
		// Write your code here.
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int[][] board = new int[n][n];
		solve(0, n, board, ans);
		return ans;
	}

	public static void solve(int col, int n, int[][] board, ArrayList<ArrayList<Integer>> ans) {
		if (col == n) {
			ArrayList<Integer> list = construct(board, n);
			ans.add(list);
			return;
		}

		for (int row = 0; row < n; row++) {
			if (isSafe(row, col, n, board)) {
				board[row][col] = 1;
				solve(col + 1, n, board, ans);
				board[row][col] = 0;
			}
		}
	}

	public static boolean isSafe(int row, int col, int n, int[][] board) {
		int duprow = row;
		int dupcol = col;
		while (row >= 0 && col >= 0) {
			if (board[row][col] == 1)
				return false;
			row--;
			col--;
		}

		row = duprow;
		col = dupcol;
		while (col >= 0) {
			if (board[row][col] == 1)
				return false;
			col--;
		}

		row = duprow;
		col = dupcol;
		while (col >= 0 && row < board.length) {
			if (board[row][col] == 1)
				return false;
			col--;
			row++;
		}
		return true;
	}

	public static ArrayList<Integer> construct(int[][] board, int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				list.add(board[i][j]);
			}
		}
		return list;
	}
}

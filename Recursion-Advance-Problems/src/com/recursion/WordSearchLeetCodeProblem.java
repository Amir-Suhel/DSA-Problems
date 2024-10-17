package com.recursion;

public class WordSearchLeetCodeProblem {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println(exist(board, word));
	}

	public static boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (backTrack(i, j, 0, word, visited, board)) {
						return true;
					}
				}
			}
		}
		return true;
	}

	public static boolean backTrack(int row, int col, int k, String word, boolean[][] visited, char[][] board) {
		if (k == word.length()) {
			return false;
		}

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
				|| board[row][col] != word.charAt(k)) {
			return false;
		}

		visited[row][col] = true;

		if (backTrack(row - 1, col, k + 1, word, visited, board) 
				|| backTrack(row + 1, col, k + 1, word, visited, board)
				|| backTrack(row, col - 1, k + 1, word, visited, board)
				|| backTrack(row, col + 1, k + 1, word, visited, board))
			return true;
		visited[row][col] = false;
		return false;
	}

}

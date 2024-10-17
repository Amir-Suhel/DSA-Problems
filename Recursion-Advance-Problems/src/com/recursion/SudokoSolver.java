package com.recursion;

public class SudokoSolver {
	static int cnt = 0;

	public static void main(String[] args) {

//		char[][] board = new char[9][9];
//		for (int i = 0; i < 9; i++)
//			Arrays.fill(board[i], '.');
		char[][] board = { { '9', '5', '7', '.', '1', '3', '.', '8', '4' },
				{ '4', '8', '3', '.', '5', '7', '1', '.', '6' }, { '.', '1', '2', '.', '4', '9', '5', '3', '7' },
				{ '1', '7', '.', '3', '.', '4', '9', '.', '2' }, { '5', '.', '4', '9', '7', '.', '3', '6', '.' },
				{ '3', '.', '9', '5', '.', '8', '7', '.', '1' }, { '8', '4', '5', '7', '9', '.', '6', '1', '3' },
				{ '.', '9', '1', '.', '3', '6', '.', '7', '5' }, { '7', '.', '6', '1', '8', '5', '4', '.', '9' } };

		printBoard(board);
		System.out.println("solved sudoko::::");
		solve(board);
		printBoard(board);
	}

	private static void printBoard(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.println("-------------------------");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0)
					System.out.print("| ");
				System.out.print(board[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("-------------------------");
		System.out.println();
	}

	private static boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {

					for (char c = '1'; c <= '9'; c++) {
						if (isValid(i, j, c, board)) {
							board[i][j] = c;

							if (solve(board)) {
								return true;
							} else
								board[i][j] = '.';
						}
					}

					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(int row, int col, char ch, char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == ch)
				return false;
			if (board[i][col] == ch)
				return false;
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
				return false;
		}
		return true;
	}

}

package com.recursion;

import java.util.ArrayList;

public class RateInMaze {

	public static void main(String[] args) {
		int n = 4;
		int[][] arr = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		ArrayList<String> paths = findPaths(arr, n);
		for (String path : paths) {
			System.out.println(path);
		}
	}

	public static ArrayList<String> findPaths(int[][] arr, int n) {
		ArrayList<String> paths = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		dfs(arr, n, 0, 0, visited, "", paths);
		return paths;
	}

	private static void dfs(int[][] arr, int n, int row, int col, boolean[][] visited, String path,
			ArrayList<String> paths) {
		if (row < 0 || col < 0 || row >= n || col >= n || arr[row][col] == 0 || visited[row][col]) {
			return;
		}

		if (row == n - 1 && col == n - 1) {
			paths.add(path);
			return;
		}

		visited[row][col] = true;

		dfs(arr, n, row + 1, col, visited, path + 'D', paths); // Down
		dfs(arr, n, row, col - 1, visited, path + 'L', paths); // Left
		dfs(arr, n, row, col + 1, visited, path + 'R', paths); // Right
		dfs(arr, n, row - 1, col, visited, path + 'U', paths); // Up

		visited[row][col] = false;
	}
}

/**
 * public class RateInMaze {
 * 
 * public static void main(String[] args) { int n = 4; // int[][] arr = new
 * int[n][n]; int[][] arr = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, {
 * 0, 1, 1, 1 } }; ArrayList<String> path = findPath(arr, n);
 * System.out.println(path);
 * 
 * }
 * 
 * public static ArrayList<String> findPath(int[][] arr, int n) { boolean[][]
 * visited = new boolean[n][n]; ArrayList<String> ans = new ArrayList<>();
 * solve(0, 0, n, new StringBuilder(), visited, arr, ans);
 * Collections.sort(ans); return ans; }
 * 
 * public static void solve(int row, int col, int n, StringBuilder ds,
 * boolean[][] visited, int[][] arr, ArrayList<String> ans) { if (row >= n - 1
 * && col >= n - 1) { ans.add(ds.toString()); return; }
 * 
 * if (row < n - 1 && arr[row + 1][col] == 1 && !visited[row + 1][col]) {
 * ds.append('D'); visited[row + 1][col] = true; solve(row + 1, col, n, ds,
 * visited, arr, ans); ds.deleteCharAt(ds.length() - 1); visited[row + 1][col] =
 * false; } if (row > 0 && arr[row - 1][col] == 1 && !visited[row - 1][col]) {
 * ds.append('U'); visited[row - 1][col] = true; solve(row - 1, col, n, ds,
 * visited, arr, ans); ds.deleteCharAt(ds.length() - 1); visited[row - 1][col] =
 * false; }
 * 
 * if (col > 0 && arr[row][col - 1] == 1 && !visited[row][col - 1]) {
 * ds.append('L'); visited[row][col - 1] = true; solve(row, col - 1, n, ds,
 * visited, arr, ans); ds.deleteCharAt(ds.length() - 1); visited[row][col - 1] =
 * false; } if (col < n - 1 && arr[row][col + 1] == 1 && !visited[row][col + 1])
 * { ds.append('R'); visited[row][col + 1] = true; solve(row, col + 1, n, ds,
 * visited, arr, ans); ds.deleteCharAt(ds.length() - 1); visited[row][col + 1] =
 * false; } }
 * 
 * }
 **/

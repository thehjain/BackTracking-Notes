//Sudoku is very famous problem where we have given 2d grid
//and we have to check if numbers are unique in every row
//column and box.


// grid = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
//          { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
//          { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
//          { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
//          { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
//          { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
//          { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
//          { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
//          { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };


//Naive approach is to check every formant possible of arranging
//the numbers and it will time complexity of (9^(N^N)).

//Efficient approach is to backtrack.

import java.util.*;
class Sudoku {
	public static void main(String[] args) {

		int[][] board = new int[][] {
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 }
		};

		int N = board.length;

		if (solve(board, N))
			printSolution(board);
		else
			System.out.println("Solution does not exist");
	}

	static void printSolution(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	static boolean solve(int[][] arr, int n) {
		int row = -1, col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty)
				break;
		}
		if (isEmpty)
			return true;

		for (int i = 1; i <= n; i++) {
			if (isSafe(arr, row, col, i)) {
				arr[row][col] = i;
				if (solve(arr, n))
					return true;
				else
					arr[row][col] = 0;
			}
		}
		return false;
	}

	static boolean isSafe(int[][] arr, int row, int col, int num) {

		//Check for row
		for (int i = 0; i < arr.length; i++)
			if (arr[row][i] == num)
				return false;
		//Check for col
		for (int i = 0; i < arr.length; i++)
			if (arr[i][col] == num)
				return false;
		//Check for box
		int sqrt = (int)Math.sqrt(arr.length);
		int boxStartRow = row - row % sqrt;
		int boxStartCol = col - col % sqrt;
		for (int i = boxStartRow; i < boxStartRow + sqrt; i++) {
			for (int j = boxStartCol; j < boxStartCol + sqrt; j++) {
				if (arr[i][j] == num)
					return false;
			}
		}
		return true;
	}

}


//Problem is present on geeksforgeeks
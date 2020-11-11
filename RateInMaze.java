//Here we have given 2d matrix or maze. And we have
//to check if rat can reach at last point or not.
//Cells are filled with 0 and 1 . 0 means cell can be used
//as a path and 1 means cell is dead and end can't be used.


//Basic approach is to check every path but efficient approach
//is to backtrack if path is not possible.


import java.util.*;
class RateInMaze {
	public static void main(String[] args) {

		int maze[][] = { { 1, 0, 0, 0 },
			{ 1, 1, 0, 1 },
			{ 0, 1, 0, 0 },
			{ 1, 1, 1, 1 }
		};

		int n = maze.length;
		solveMaze(maze, n);
	}

	static void printSolution(int[][] sol) {
		System.out.println("path followed is repsented by one's in array");
		for (int[] row : sol) {
			for (int ele : row)
				System.out.print(ele + " ");
			System.out.println();
		}
		return;
	}

	static boolean isSafe(int[][] maze, int row, int col) {
		if (row >= 0 && row < maze.length)
			if (col >= 0 && col < maze.length)
				if (maze[row][col] == 1)
					return true;
		return false;
	}

	static boolean solveMazeUtil(int[][] maze, int[][] sol, int row, int col) {

		if (row == maze.length - 1 && col == maze.length - 1 && maze[row][col] == 1) {
			sol[row][col] = 1;
			return true;
		}

		if (isSafe(maze, row, col)) {
			sol[row][col] = 1;
			if (solveMazeUtil(maze, sol, row + 1, col))
				return true;
			if (solveMazeUtil(maze, sol, row, col + 1))
				return true;

			sol[row][col] = 1;
			return false;
		}
		return false;
	}

	static void solveMaze(int[][] maze, int n) {

		int[][] sol = new int[n][n];

		if (!solveMazeUtil(maze, sol, 0, 0))
			System.out.println("Solution does not exist");
		else
			printSolution(sol);

	}
}


//Question is available on geeksforgeeks
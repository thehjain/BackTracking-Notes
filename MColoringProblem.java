//Here we have given undirected graph and m colors
//We have to check if graph can be colored with using
//this m colors so that no two adjacent nodes colors
//are different.

//Naive approach is to check all the possible cases.

//Another efficient approach is to use backtracking.

import java.util.*;
class MColoringProblem {

	static int V = 4;
	static int[] color;

	public static void main(String[] args) {
		int graph[][] = {
			{ 0, 1, 1, 1 },
			{ 1, 0, 1, 0 },
			{ 1, 1, 0, 1 },
			{ 1, 0, 1, 0 },
		};

		int m = 3;
		graphColoring(graph, m);
	}

	static void printSolution(int[] color) {
		System.out.println("Assigned Colors");
		for (int ele : color)
			System.out.print(ele + " ");
	}

	static boolean isSafe(int[] color, int c, int[][] arr, int v) {
		for (int i = 0; i < V; i++)
			if (arr[v][i] == 1 && c == color[i])
				return false;
		return true;
	}

	static boolean graphColoringUtil(int[][] arr, int m, int[] color, int v) {
		if (v == V)
			return true;
		for (int c = 1; c <= m; c++) {
			if (isSafe(color, c, arr, v)) {
				color[v] = c;
				if (graphColoringUtil(arr, m, color, v + 1))
					return true;
				color[v] = 0;
			}
		}
		return false;
	}

	static void graphColoring(int[][] arr, int m) {

		color = new int[V];
		Arrays.fill(color, 0);

		if (!graphColoringUtil(arr, m, color, 0))
			System.out.println("Solution does not exist");
		else
			printSolution(color);

	}
}



//Problem is present on geeksforgeeks
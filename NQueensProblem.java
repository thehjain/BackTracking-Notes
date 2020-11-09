
//Here we have given N*N matrix or chess and we have to place
//n queens , such that no two queens paths intersect in
//any direction.


//Naive approach is check all solutions.


// 1) Start in the leftmost column
// 2) If all queens are placed
//     return true
// 3) Try all rows in the current column.
//    Do following for every tried row.
//     a) If the queen can be placed safely in this row
//        then mark this [row, column] as part of the
//        solution and recursively check if placing
//        queen here leads to a solution.
//     b) If placing the queen in [row, column] leads to
//        a solution then return true.
//     c) If placing queen doesn't lead to a solution then
//        unmark this [row, column] (Backtrack) and go to
//        step (a) to try other rows.
// 3) If all rows have been tried and nothing worked,
//    return false to trigger backtracking.

import java.util.*;

class NQueensProblem {

    static int N = 4;

    public static void main(String[] args) {
        solve();
    }

    static void printSolution(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solve() {

        int board[][] = { { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }
        };

        if (!solveUtil(board, 0))
            System.out.println("Solution does not exist");
        else
            printSolution(board);

    }

    static boolean solveUtil(int[][] arr, int col) {

        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(arr, i, col)) {
                arr[i][col] = 1;
                if (solveUtil(arr, col + 1))
                    return true;
                arr[i][col] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int[][] arr, int row, int col) {

        //int i, j;
        for (int i = 0; i < col; i++)
            if (arr[row][i] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (arr[i][j] == 1)
                return false;
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (arr[i][j] == 1)
                return false;
        return true;
    }

}


//Problem is available on geeksforgeeks
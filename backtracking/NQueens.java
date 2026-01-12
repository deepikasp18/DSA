package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> solutions = solveNQueens(n);

        System.out.println("Total solutions for " + n + "-Queens: " + solutions.size());
        System.out.println("Solutions:" + solutions);
    }

    public static List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int n, int row) {
        if (row == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(current, row, col)) {
                current.add(col);
                backtrack(result, current, n, row + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isValid(List<Integer> current, int row, int col) {
        // Check for conflicts with previously placed queens
        // For each previously placed queen at (r, c): 
        for (int r = 0; r < row; r++) {
            int c = current.get(r); // column of the queen in row r
            // Two queens threaten each other if they are in the same column or on the same diagonal
            // eg. (r1, c1) and (r2, c2) are on the same diagonal if |c1 - c2| == |r1 - r2|
            if (c == col || Math.abs(c - col) == Math.abs(r - row)) {
                return false;
            }
        }
        return true;
    }
}
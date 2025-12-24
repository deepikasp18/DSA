package DP;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 5;
        System.out.println("Number of unique paths: " + uniquePaths(m, n));
        System.out.println("Number of unique paths: " + uniquePathsSpaceOptimized(3, 5));
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i=0; i<m; i++) {
            dp[i][0] = 1; // Only one way to reach any cell in the first column
        }

        for (int j=0; j<n; j++) {
            dp[0][j] = 1; // Only one way to reach any cell in the first row
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; // Sum of ways from the top and left cells
            }
        }

        return dp[m-1][n-1];
    }

    private static int uniquePathsSpaceOptimized(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // Update the current cell with the sum of ways from the left and top (dp[j] = top, dp[j-1] = left)
            }
        }
        return dp[n - 1];
    }
}

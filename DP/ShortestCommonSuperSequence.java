package DP;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println("Length of Shortest Common Supersequence: " + shortestCommonSupersequence(str1, str2));
    }

    private static int shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;

        for (int i=1; i<=m; i++) {
            dp[i][0] = i; // If str2 is empty, SCS is str1
        }

        for (int j=1; j<=n; j++) {
            dp[0][j] = j; // If str1 is empty, SCS is str2
        }

        // Fill the dp array for Longest Common Subsequence (LCS)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Characters match, add 1 to LCS
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]); // Characters don't match, take either of those characters which results in min length and add 1
                }
            }
        }

        return dp[m][n];
    }
}

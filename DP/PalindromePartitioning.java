package dp;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "geek";
        int minCuts = minCut(s);
        System.out.println("Minimum cuts needed for palindrome partitioning: " + minCuts);
    }

    private static int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i=0; i<n; i++) {
            dp[i][i] = 0;
            isPalindrome[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                } else {
                    isPalindrome[i][j] = false;
                }

                if (isPalindrome[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + 1);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

}

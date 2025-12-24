package DP;

/**
 * Given an integer array of coins[] of size n representing different types of denominations and an integer sum, the task is to count all combinations of coins to make a given value sum.  

Note: Assume that you have an infinite supply of each type of coin. 
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println("Number of ways to make change: " + countWaysSpaceOptimized(coins, sum));
    }
    
    private static int countWays(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1; // Base case: one way to make sum 0 with 0 coins

        for (int j=1; j<=sum; j++) {
            dp[0][j] = 0; // No way to make positive sum with 0 coins
        }

        for (int i=1; i<=n; i++) {
            for (int j=0; j<=sum; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]; // Exclude the coin + Include the coin
                } else {
                    dp[i][j] = dp[i-1][j]; // Exclude the coin if the coin value is greater than the sum
                }
            }
        }
        return dp[n][sum];
    }

    private static int countWaysSpaceOptimized(int[] coins, int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1; // Base case: one way to make sum

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]]; 
            }
        }

        return dp[sum];
    }
}

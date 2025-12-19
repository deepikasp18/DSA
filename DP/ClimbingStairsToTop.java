package DP;

/*
    There are n stairs, and a person standing at the bottom wants to climb stairs to reach the top. The person can climb either 1 stair or 2 stairs at a time, the task is to count the number of ways that a person can reach at the top.
*/
public class ClimbingStairsToTop {
    public static void main(String[] args) {
        int n = 5; // Number of stairs
        System.out.println("Number of ways to climb to the top: " + countWays(n));
    }

    private static int countWays(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at the ground (do nothing)
        dp[1] = 1; // 1 way to climb the first stair

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

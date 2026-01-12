package dp;

/**
 * There are n houses built in a line, each of which contains some money in it. A robber wants to steal money from these houses, but he can’t steal from two adjacent houses. The task is to find the maximum amount of money which can be stolen.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("Maximum amount that can be robbed: " + rob(houses));
        System.out.println("Maximum amount that can be robbed: " + robOptimized(houses));
    }

    private static int rob(int[] houses) {
        if (houses == null || houses.length == 0) {
            return 0;
        }

        if (houses.length == 1) {
            return houses[0];
        }

        int n = houses.length;
        int[] dp = new int[n+1];
        dp[0] = 0; // No houses to rob
        dp[1] = houses[0]; // Only one house to rob

        for (int i=2; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + houses[i-1]); // Max of robbing current house or skipping it
        }
        return dp[n];
    }

    private static int robOptimized(int[] houses) {
        if (houses == null || houses.length == 0) {
            return 0;
        }

        if (houses.length == 1) {
            return houses[0];
        }

        int prev = houses[0]; // Max amount after robbing the first house
        int prevOfPrev = 0; // Max amount before the first house

        int current = 0;
        for (int i=1; i<houses.length; i++) {
            current = Math.max(prev, prevOfPrev + houses[i]); // Max of robbing current house or skipping it
            prevOfPrev = prev;
            prev = current;
        }
        return current;
    }
}

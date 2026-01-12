package dp;

/**
 * Given an array of integers cost[] of length n, where cost[i] is the cost of the ith step on a staircase. Once the cost is paid, we can either climb one or two steps.
We can either start from the step with index 0, or the step with index 1. The task is to find the minimum cost to reach the top.
 */

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Minimum cost to reach the top: " + minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        if (n == 1) {
            return cost[0];
        }

        int[] minCost = new int[n];
        minCost[0] = cost[0]; // Cost to reach step 0
        minCost[1] = cost[1]; // Cost to reach step 1

        for (int i=2; i<n; i++) {
            minCost[i] = Math.min(minCost[i-1], minCost[i-2]) + cost[i];
        }

        return Math.min(minCost[n-2], minCost[n-1]);
    }
}

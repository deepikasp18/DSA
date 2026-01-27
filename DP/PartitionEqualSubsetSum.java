package dp;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5, 3, 3, 4};
        boolean canPartition = canPartition(nums);
        System.out.println("Can partition: " + canPartition);
    }

    private static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num: nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length + 1][totalSum / 2 + 1];

        // Initialize the first column as true (0 sum is possible with any number of elements)
        for (int i= 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i=1; i <= nums.length; i++) {
            for (int j = 1; j <= totalSum / 2; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][totalSum / 2];
    
    }
}

package Miscellaneous;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int maxProduct = maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + maxProduct);
    }

    private static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currMax = nums[0];
        int currMin = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prevMax = currMax;
            currMax = Math.max(Math.max(currMax * nums[i], currMin * nums[i]), nums[i]);
            currMin = Math.min(Math.min(prevMax * nums[i], currMin * nums[i]), nums[i]);

            globalMax = Math.max(globalMax, currMax);
        }

        return globalMax;
    }
}

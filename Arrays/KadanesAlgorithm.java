/*
 * Kadane’s Algorithm is a dynamic programming algorithm used to find the maximum subarray sum in an array of numbers. It efficiently solves the maximum subarray problem and has a time complexity of O(n), where n is the size of the array.

Problem statement:

Given an array of N integers a1,a2,a3,….., aN . Find the maximum subarray(non-empty) sum of the given array.

For example: Array A[]= [-1, 2, -2, 5, 7, -3, 1]

Maximum subarray sum -> 12 Subarray(0-Based indexed) from index 1 to 4 -> [2, -2, 5, 7] and subarray(0-Based indexed) from index 3 to 4 -> [5, 7] have sum 12.

Kadane’s Algorithm The idea of Kadane’s algorithm is to maintain a maximum subarray sum ending at every index ‘i’ of the given array and update the maximum sum obtained by comparing it with the maximum sum of the subarray ending at every index ‘i’. At any given index ‘i’ of the array, we can either: ●Append the element at index ‘i’ to the maximum sum subarray(so just add the element at index ‘i’ to the maximum you’ve found so far). ●Start a new subarray starting from index ‘i’. Appending an element at index ‘i’ to the maximum sum subarray obtained so far is beneficial if the sum till index ‘i-1’ is non-negative, otherwise it is better to start a new subarray starting from index ‘i’ and update the maximum sum obtained accordingly.
 */
public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] array = {1,3,2,-2,3,-5,4,8};
        int maxSubArraySum = kadanes(array);
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum);
    }

    public static int kadanes(int[] array) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num: array) {
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;  

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("Length of Longest Increasing Subsequence: " + lis(arr));
        System.out.println("Length of Longest Increasing Subsequence (Efficient): " + lisEfficient(arr));
    }

    private static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxLength = 1;

        for (int i =0; i<n; i++) {
            dp[i] = 1; // Each element is an increasing subsequence of length 1
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    /*
    The main idea of the approach is to simulate the process of finding a subsequence by maintaining a list of "buckets" where each bucket represents a valid subsequence. Initially, we start with an empty list and iterate through the input vector arr from left to right.

For each number in arr, we perform the following steps:

If the number is greater than the last element of the last bucket (i.e., the largest element in the current subsequence), we append the number to the end of the list. This indicates that we have found a longer subsequence.
Otherwise, we perform a binary search on the list of buckets to find the smallest element that is greater than or equal to the current number. This step helps us maintain the property of increasing elements in the buckets.
Once we find the position to update, we replace that element with the current number. This keeps the buckets sorted and ensures that we have the potential for a longer subsequence in the future.
Note: The resulting array only stores the length of longest increasing subsequence, and not the actual subsequence. Go through the illustration to clear this doubt.

Illustration:

Example: arr = [3, 4, 5, 1, 2, 3, 4] Let's see why keeping 1 (the smallest value) helps:

We use binary search to find the position where new element is to be inserted.

First three elements: buckets = [3, 4, 5]
arr[3] = 1 buckets = [1, 4, 5]  // 1 replaces 3
arr[4] = 2 buckets = [1, 2, 5]  // 2 replaces 4 as it's smaller
arr[5] = 3 buckets = [1, 2, 3]  // 3 replaces 5
arr[6] = 4 buckets = [1, 2, 3, 4]  // 4 is appended as it's larger
This shows that by replacing 3 with 1, we created the opportunity to find the subsequence [1, 2, 3, 4], which is longer than our initial [3, 4, 5]. If we had kept [3, 4, 5], we wouldn't have been able to add 2 to our sequence!

The key insight is that keeping smaller values at each position:

Maintains the same length information
Creates more opportunities for future elements to form longer increasing subsequences
    */
    private static int lisEfficient(int[] arr) {
        int n = arr.length;
        List<Integer> longestIncreasingSubsequence = new ArrayList<>();
        longestIncreasingSubsequence.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > longestIncreasingSubsequence.get(longestIncreasingSubsequence.size() - 1)) {
                longestIncreasingSubsequence.add(arr[i]);
            } else {
                int index = Collections.binarySearch(longestIncreasingSubsequence, arr[i]);
                if (index < 0) { // If not found, binarySearch returns (-(insertion point) - 1)
                    index = -(index + 1);
                }
                longestIncreasingSubsequence.set(index, arr[i]);
            }
        }
        return longestIncreasingSubsequence.size();
    }


}

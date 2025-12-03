/*
 * Problem Statement: You are given an array of integers ARR[] and size of N consisting of zeros and one’s .You have to select a subset and flip the bits of that subsets . You have to return the count of maximum one’s that you can obtain by flipping choosing subarray’s at most once. A flip operation is one in which you turn 1 into 0 and 0 into 1.

Constraints:

1 ≤ T = 100, 1 < N ≤ 10⁴, 0 ≤ ARR[i] ≤ 1.

Walk through: If you are given an array of {1,1,0,0,1,1} .Then you will have to return the count of the maximum one’s you can obtain by flipping any choosing sub-array at most once . so here you will clearly sub-array from the index of 2 to 3 .And flip its bits , So the final array comes out to be { 1,1,1,1,1,1} which contains 5 one’s so you will return 5.
 */
public class FlipBits {
    public static void main(String[] args) {
        int[] array = {1, 0, 0, 1, 0, 1, 1};
        int result = maxOnesAfterFlip(array);
        System.out.println("Maximum number of 1's after flip: " + result);
    }

    public static int maxOnesAfterFlip(int[] array) {
        int totalOnesBeforeFlip = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                totalOnesBeforeFlip++;
                array[i] = -1; // Flipping 1 to -1
            } else {
                array[i] = 1;  // Flipping 0 to 1
            }
        }

        int maxGain = kadanes(array);
        return totalOnesBeforeFlip + maxGain;
    }

    public static int kadanes(int[] array) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num: array) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}

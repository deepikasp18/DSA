package greedy;

/*
Given an array arr[] where each element represents the maximum number of steps
you can move forward from that position. Find the minimum number of jumps required
to reach the last index, if you are starting from the 0th index.

Note: If it is not possible to reach the last index, return -1.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] maxSteps = {1,3,4,5,2,3};
        System.out.println("Min jumps to reach last index: %d".formatted(minJumps(maxSteps)));
    }

    private static int minJumps(int[] maxSteps) {
        int n = maxSteps.length;

        if (n == 0 || maxSteps[0] == 0) {
            return 0;
        }

        int jumps = 0;
        int currentRangeEndIndex = 0; // range of indexes that can be jumped with N jumps
        int maxReachableIndex = 0; // Max index that can be reached from the current range

        for (int i = 0; i < n; i++) {
            maxReachableIndex = Math.max(maxReachableIndex, i + maxSteps[i]);

            if (maxReachableIndex >= n - 1) {
                jumps++;
                break;
            }

            if (i == currentRangeEndIndex) {
                if (currentRangeEndIndex == maxReachableIndex) {
                    return -1;
                }
                jumps++; // explored all possible options in the current range, time to make the next jump
                currentRangeEndIndex = maxReachableIndex; // make a jump to the maximum reachable index from the current range
            }
        }

        return jumps;
    }
}

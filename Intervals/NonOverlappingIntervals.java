package Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {1, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(intervals));
    }

    private static int minRemoval(int[][] intervals) {
        int n = intervals.length;
        int removalCount = 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < end) {
                removalCount++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }

        return removalCount;
    }
}

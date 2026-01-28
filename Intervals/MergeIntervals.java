package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,5}, {2,6}, {3,5}, {7,9}, {10, 12}
        };

        List<int[]> mergedIntervals = mergeOverlappingIntervals(intervals);
        System.out.println("Merged intervals:");
        for(int[] interval: mergedIntervals) {
            System.out.printf("%d - %d\n", interval[0], interval[1]);
        }
    }

    private static List<int[]> mergeOverlappingIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < n; i++) {
           int[] lastMerged = result.getLast();
           int[] curr = intervals[i];

           if (curr[0] <= lastMerged[1]) {
               lastMerged[1] = Math.max(lastMerged[1], curr[1]);
           } else {
               result.add(new int[]{curr[0], curr[1]});
           }
        }

        return result;
    }
}

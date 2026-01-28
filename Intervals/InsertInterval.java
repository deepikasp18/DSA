package Intervals;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of non-overlapping intervals[][] where intervals[i] = [starti , endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti and a new interval,
 insert the interval at the correct position such that after insertion, the intervals remain sorted. If the insertion results in overlapping intervals, then merge the overlapping intervals.
 Assume that the set of non-overlapping intervals is sorted based on start time.
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3}, {5,7}, {8,10}
        };

        int[] newInterval = {4,5};

        List<int[]> result = insertInterval(intervals, newInterval);
        for(int[] interval: result) {
            System.out.printf("%d-%d\n", interval[0], interval[1]);
        }
    }

    private static List<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;

        int i=0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(new int[]{newInterval[0], newInterval[1]});

        while (i < n) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        return result;
    }
}

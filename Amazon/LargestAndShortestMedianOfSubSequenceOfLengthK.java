package Amazon;

import java.util.ArrayList;
import java.util.List;

public class LargestAndShortestMedianOfSubSequenceOfLengthK {
    public static void main(String[] args) {
        int[] array = {5,1,4,2,3,6};
        int k = 3;
        int[] result = findLargestAndShortestMedian(array, k);
        System.out.println("Largest Median: " + result[0]);
        System.out.println("Shortest Median: " + result[1]);
    }

    public static int[] findLargestAndShortestMedian(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            throw new IllegalArgumentException("k cannot be greater than the length of the array");
        }

        int largestMedian = Integer.MIN_VALUE;
        int shortestMedian = Integer.MAX_VALUE;

        List<List<Integer>> subsequences = new ArrayList<>();
        backtrack(subsequences, new ArrayList<>(), nums, 0, k);

        for (List<Integer> subsequence : subsequences) {
            subsequence.sort(Integer::compareTo);
            int median;
            if (k % 2 == 1) {
                median = subsequence.get(k / 2);
            } else {
                median = (subsequence.get(k / 2 - 1) + subsequence.get(k / 2)) / 2;
            }

            largestMedian = Math.max(largestMedian, median);
            shortestMedian = Math.min(shortestMedian, median);
        }

        return new int[]{largestMedian, shortestMedian};
    }

    private static void backtrack(List<List<Integer>> subsequences, List<Integer> current, int[] nums, int start, int k) {
        if (current.size() == k) {
            subsequences.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(subsequences, current, nums, i + 1, k);
            current.remove(current.size() - 1);
        }
    }
}
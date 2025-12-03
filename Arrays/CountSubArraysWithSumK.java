import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        int count = countSubArraysWithSumK(arr, k);
        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }

    private static int countSubArraysWithSumK(int[] arr, int k) {
        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        for (int num : arr) {
            currSum += num;

            if (currSum == k) {
                count++;
            }

            if (prefixSumCount.containsKey(currSum - k)) {
                count += prefixSumCount.get(currSum - k);
            }

            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}

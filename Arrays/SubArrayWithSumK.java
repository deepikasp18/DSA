
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int k = 12;
        int[] result = subArrayWithSumK(arr, k);
        if (result != null) {
            System.out.println("Subarray with sum " + k + " found from index " + result[0] + " to " + result[1]);
        } else {
            System.out.println("No subarray with sum " + k + " found.");
        }
    }

    public static int[] subArrayWithSumK(int[] arr, int k) {
        int currSum = 0;
        int start = 0;

        Map<Integer, Integer> prefixSum = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            currSum += arr[i];

            if (currSum == k) {
                return new int[] {0, i};
            }

            if (prefixSum.containsKey(currSum - k)) {
                start = prefixSum.get(currSum - k) + 1;
                return new int[] {start, i};
            }

            prefixSum.put(currSum, i);
        }

        return new int[]{-1, -1}; // Return -1 if no subarray is found
    }
}

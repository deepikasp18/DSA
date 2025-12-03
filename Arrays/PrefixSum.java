public class PrefixSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] prefixSumArray = computePrefixSum(array);
        System.out.println("Prefix Sum Array:");
        for (int sum : prefixSumArray) {
            System.out.print(sum + " ");
        }
    }

    public static int[] computePrefixSum(int[] array) {
        int[] prefixSum = new int[array.length];
        prefixSum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }
        return prefixSum;
    }
}

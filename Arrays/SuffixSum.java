public class SuffixSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] suffixSumArray = computeSuffixSum(array);
        System.out.println("Suffix Sum Array:");
        for (int sum : suffixSumArray) {
            System.out.print(sum + " ");
        }
    }

    public static int[] computeSuffixSum(int[] array) {
        int n = array.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = array[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + array[i];
        }
        return suffixSum;
    }
}

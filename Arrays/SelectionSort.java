public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        selectionSort(array);
        System.out.print("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int idx = 0; idx < n - 1; idx++) {
            int minIdx = idx;
            for (int j = idx+1; j< n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIdx];
            array[minIdx] = array[idx];
            array[idx] = temp;
        }
    }
}

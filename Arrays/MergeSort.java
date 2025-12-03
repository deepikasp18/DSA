public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array, 0, array.length - 1);
        System.out.print("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int leftSubArraySize = mid - left + 1;
        int rightSubArraySize = right - mid;

        int[] leftSubArray = new int[leftSubArraySize];
        int[] rightSubArray = new int[rightSubArraySize];

        for (int i = 0; i<leftSubArraySize; i++) {
            leftSubArray[i] = array[left + i];
        }
        for (int j = 0; j < rightSubArraySize; j++) {
            rightSubArray[j] = array[mid + j + 1];
        }

        int i = 0,j=0;
        int k = left;

        while (i < leftSubArraySize && j < rightSubArraySize) {
            if (leftSubArray[i] < rightSubArray[j]) {
                array[k] = leftSubArray[i];
                i++;
            } else {
                array[k] = rightSubArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSubArraySize) {
            array[k] = leftSubArray[i];
            i++;
            k++;
        }

        while (j < rightSubArraySize) {
            array[k] = rightSubArray[j];
            j++;
            k++;
        }
    }
}

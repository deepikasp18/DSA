public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 9, 3};
        int target = 7;
        int resultIndex = linearSearch(array, target);
        if (resultIndex != -1) {
            System.out.println("Element found at index: " + resultIndex);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

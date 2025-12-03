/*
 * The Dutch National Flag algorithm, also known as the 3-way partitioning algorithm , is a sorting algorithm proposed by Dutch computer scientist Edsger Dijkstra. It is named after the Dutch national flag because it was originally designed to solve a problem related to sorting arrays with three distinct values. The algorithm is used to partition an array of elements with three possible values (commonly represented as colours) into three regions: elements that are smaller than a given value, elements that are equal to the given value, and elements that are larger than the given value. The goal is to rearrange the elements in the array in linear time complexity.

The Dutch National Flag algorithm or three-way partitioning algorithm allows sorting the array consisting of 0s, 1s, and 2s in a single traversal only and in constant space. Steps: ●Maintain three indices low = 0, mid = 0, and high = N-1, where N is the number of elements in the array.

The range from 0 to low denotes the range containing 0s.
The range from low to mid denotes the range containing 1s.
The range from mid to high denotes the range containing any of 0s, 1s, or 2s.
The range from high to N-1 denotes the range containing 2s. ●The mid pointer denotes the current element, traverses the array while mid<=high i.e we have exhausted the search space for the range which can contain any of 0s, 1s, or 2s. 1.If A[mid] == 0, swap A[mid] and A[low] and increment low and mid pointers by 1. 2.If A[mid] == 1, increment the mid pointer by 1. 3.If A[mid] == 2, swap A[high] and A[mid] and increment mid by 1 and decrement high by 1. The resulting array will be a sorted array containing 0s, 1s, and 2s.
 */
public class DutchNationalFlagAlgorithm {
    public static void main(String[] args) {
        int[] array = {2, 0, 1, 2, 1, 0, 1, 2};
        dutchNationalFlagSort(array);
        System.out.print("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void dutchNationalFlagSort(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while (mid <= high) {
            switch (array[mid]) {
                case 0 ->                     {
                        // Swap array[low] and array[mid]
                        int temp = array[low];
                        array[low] = array[mid];
                        array[mid] = temp;
                        low++;
                        mid++;
                    }
                case 1 -> mid++;
                default ->                     {
                        // array[mid] == 2
                        // Swap array[mid] and array[high]
                        int temp = array[mid];
                        array[mid] = array[high];
                        array[high] = temp;
                        high--;
                    }
            }
        }
    }
}

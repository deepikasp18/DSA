/*
 * Problem Statement : Aahad and Harsit always have fun in solving problems .Harsit took a sorted array consisting of distinct integers and rotated it clockwise by an unknown amount. For example , he took a sorted array =[ 1,2,3,4,5] and if he rotates it by 2 , then the array becomes: [4,5,1,2,3] . After rotating a sorted array , Aahad needs to answer Q queries asked by Harsit , each of them is described by one integer Q[i] . which Harsit wanted him to search in the array . For each query , if he found it .He had to shout the index of the number , otherwise he had to shout -1. For each query you have to complete the given ‘key’ denotes Q[i]. if the key exists in the array , return the index of the ‘key’ otherwise return -1.

Constraints:

1≤ N ≤ 10⁶ , -10⁹ ≤ A[i] ≤ 10⁹ , 1 ≤ Q ≤ 10⁵ , -10⁹ ≤ Q[i] ≤ 10⁹
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2};
        int target = 0;
        int resultIndex = searchInRotatedSortedArray(array, target);
        if (resultIndex != -1) {
            System.out.println("Element found at index: " + resultIndex);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    public static int searchInRotatedSortedArray(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            }
        
            // Check if the left half is sorted
            if (array[low] <= array[mid]) {
                if (target >= array[low] && target < array[mid]) {
                    high = mid - 1; // Target is in the left half
                } else {
                    low = mid + 1; // Target is in the right half
                }
            }
            // Right half must be sorted
            else {
                if (target > array[mid] && target <= array[high]) {
                    low = mid + 1; // Target is in the right half
                } else {
                    high = mid - 1; // Target is in the left half
                }
            }
        }
        return -1; // Target not found
    }
}

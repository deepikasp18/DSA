
import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] array = {1,4,3,9,7,2,5,6,8};
        boolean found = threeSumWithTwoPointer(array, 15);
        System.out.println("Three Sum Found: " + found);
        found = threeSumWithHashing(array, 15);
        System.out.println("Three Sum Found: " + found);
    }

    public static boolean threeSumWithTwoPointer(int[] array, int target) {
        Arrays.sort(array);

        for (int i=0; i<array.length-2; i++) {
            int left = i+1;
            int right = array.length-1;

            int requiredSum = target - array[i];

            while(left < right) {
                if (array[left] + array[right] == requiredSum) {
                    return true;
                } else if (array[left] + array[right] < requiredSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

    public static boolean threeSumWithHashing(int[] array, int target) {
        for (int i=0; i<array.length-2; i++) {
            int requiredSum = target - array[i];
            java.util.HashSet<Integer> seen = new java.util.HashSet<>();

            for (int j=i+1; j<array.length; j++) {
                int complement = requiredSum - array[j];
                if (seen.contains(complement)) {
                    return true;
                }
                seen.add(array[j]);
            }
        }
        return false;
    }
}

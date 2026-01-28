package greedy;
/*
Given an array of n integers. We need to reduce size of array to one.
We are allowed to select a pair of integers and remove the larger one of these two.
This decreases the array size by 1. Cost of this operation is equal to value of smallest one.
Find out minimum sum of costs of operations needed to convert the array into a single element.
 */
public class MinCostToMakeArraySize1 {
    public static void main(String[] args) {
        int[] array = {4,3,7,5,9};
        System.out.println("Min cost to make the array size 1 is %d".formatted(minCost(array)));
    }

    private static int minCost(int[] array) {
        int n = array.length;

        if (n == 0 || n == 1) {
            return 0;
        }

        int min = array[0];

        for (int i = 1; i < n; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return (n-1) * min; // always pick the smallest number as part of the pair and remove the larger number
    }
}

package Heaps;

import java.util.PriorityQueue;

public class KClosestPoints {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}, {2, -3}, {4, 4}};
        int k = 3;

        int[][] closestPoints = findKClosestPoints(points, k);
        System.out.println(k + " closest points are:");
        for (int[] point : closestPoints) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }

    private static int[][] findKClosestPoints(int[][] points, int k) {
        // Max-heap to store the closest k points with respect to their distance from the origin
        // The comparator orders points by their squared distance in descending order (farthest first)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            // Inverting the order for max-heap behavior (descending order)
            (a, b) -> Integer.compare(distanceSquared(b), distanceSquared(a))
        );

        for (int[] point : points) {
            // Add the current point to the max-heap
            maxHeap.offer(point);
            // If the size of the heap exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[maxHeap.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    private static int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    /**
     * Priority Queue in Java by default implements a Min-Heap.
     * To create a Max-Heap, we can use a custom comparator that inverts the natural ordering.
     * 
     * Example:
     * PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
     * Compare logic:
     * compare(a, b):
     *   - return negative if a < b
     *  - return zero if a == b
     *  - return positive if a > b
     * 
     * This will create a max-heap for integers.
     * 
     * For complex objects, we can define the comparator based on the desired property.
     * 
     * example for integer:
     * maxheap = [2, 3]
     * 
     * maxheap.offer(1) -> [3, 2, 1] 
     *     - add 1 to the end of the heap
     *     - check heap property
     *     - comparator.compare(child, parent) => compare(1, 3) => negative => no swap needed
     *
     * maxheap.offer(4) -> [4, 3, 1, 2]
     *   - add 4 to the end of the heap [3, 2, 1, 4]
     *  - check heap property
     * - comparator.compare(4, 2) => positive => swap => [3, 4, 1, 2]
     * - check heap property again
     * - comparator.compare(4, 3) => positive => swap => [4, 3, 1, 2]
     * - final maxheap = [4, 3, 1, 2]
     * 
     * 
     * 
     */
}

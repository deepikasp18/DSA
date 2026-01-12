package Heaps;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int kthLargest = findKthLargest(arr, k);
        System.out.println(k + "th largest element is: " + kthLargest);
    }

    /*
        If we maintain a min-heap of size k, the root of the heap will be the kth largest element.

        Array - [3, 2, 1, 5, 6, 4], k = 2
        Step 1: Insert elements into the min-heap
        Min-Heap after inserting 3: [3]
        Min-Heap after inserting 2: [2, 3]
        Min-Heap after inserting 1: [1, 3, 2] (size exceeds k, remove 1)
        Min-Heap after inserting 5: [2, 3, 5] (size exceeds k, remove 2)
        Min-Heap after inserting 6: [3, 5, 6] (size exceeds k, remove 3)
        Min-Heap after inserting 4: [4, 5, 6] (size exceeds k, remove 4)
        Final Min-Heap: [5, 6]
        Step 2: The root of the min-heap is 5, which is the 2nd largest element.

    */
    private static int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap();

        for (int num : nums) {
            minHeap.push(num);
            // Maintain the size of the heap to be at most k
            if (minHeap.size > k) {
                // Remove the smallest element 
                minHeap.pop();
            }
        }

        // The root of the min-heap with size k is the kth largest element
        return minHeap.heap.get(0);
    }

    public static class MinHeap {
        List<Integer> heap;
        int size;

        public MinHeap() {
            this.size = 0;
            this.heap = new ArrayList<>();
        }

        public void push(int val) {
            heap.add(val);
            size++;
            heapify(size - 1);
        }

        public void pop() {
            if (size == 0) return;
            heap.set(0, heap.get(size - 1));
            heap.remove(size - 1);
            size--;
            heapify(0);
        }

        private void heapify(int index) {
            int smallest = index;
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (leftChild < size && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }

            if (rightChild < size && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }

            if (smallest != index) {
                int temp = heap.get(index);
                heap.set(index, heap.get(smallest));
                heap.set(smallest, temp);
                heapify(smallest);
            }
        }
    } 
}

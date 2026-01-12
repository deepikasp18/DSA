package Heaps;

public class MinHeapify {
    public static void main(String[] args) {
        int[] heap = {3, 1, 6, 5, 2, 4};
        int n = heap.length;

        System.out.println("Original Heap:");
        printArray(heap);

        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(heap, n, i);
        }

        System.out.println("Heap after Min-Heapify:");
        printArray(heap);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void minHeapify(int[] heap, int n, int i) {
        int smallest = i; // Initialize smallest as root
        int leftChild = 2 * i + 1; // left child index
        int rightChild = 2 * i + 2; // right child index

        // If left child is smaller than root
        if (leftChild < n && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }

        // If right child is smaller than smallest so far
        if (rightChild < n && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        // If smallest is not root
        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            // Recursively heapify the affected sub-tree
            minHeapify(heap, n, smallest);
        }
    }
}
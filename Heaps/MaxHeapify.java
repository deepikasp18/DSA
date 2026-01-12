package Heaps;

public class MaxHeapify {
    public static void main(String[] args) {
        int[] heap = {3, 1, 6, 5, 2, 4};
        int n = heap.length;

        System.out.println("Original Heap:");
        printArray(heap);

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, n, i);
        }

        System.out.println("Heap after Max-Heapify:");
        printArray(heap);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void maxHeapify(int[] heap, int n, int i) {
        int largest = i; // Initialize largest as root
        int leftChild = 2 * i + 1; // left child index
        int rightChild = 2 * i + 2; // right child index

        // If left child is larger than root
        if (leftChild < n && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        // If right child is larger than largest so far
        if (rightChild < n && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        // If largest is not root
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            // Recursively heapify the affected sub-tree
            maxHeapify(heap, n, largest);
        }
    }
}

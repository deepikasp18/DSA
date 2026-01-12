package Heaps;

import java.util.List;

public class MaxHeap {
        List<Integer> heap;
        int size;

        public MaxHeap() {
            this.size = 0;
            this.heap = new java.util.ArrayList<>();
        }

        public void add(int val) {
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
            int largest = index;
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }

            if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }

            if (largest != index) {
                int temp = heap.get(index);
                heap.set(index, heap.get(largest));
                heap.set(largest, temp);
                heapify(largest);
            }
        }
}


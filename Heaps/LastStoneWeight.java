package Heaps;


public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int lastStoneWeight = findLastStoneWeight(stones);
        System.out.println("Last stone weight is: " + lastStoneWeight);
    }

    private static int findLastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        if (stones.length == 1) {
            return stones[0];
        }

        MaxHeap maxHeap = new MaxHeap();
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        int n = stones.length;

        while (n > 1) {
            int stone1 = maxHeap.heap.get(0);
            maxHeap.pop();
            int stone2 = maxHeap.heap.get(0);
            maxHeap.pop();

            if (stone1 != stone2) {
                maxHeap.add(Math.abs(stone1 - stone2));
                n--;
            } else {
                n -= 2;
            }
        }

        return maxHeap.heap.isEmpty() ? 0 : maxHeap.heap.get(0);
    }
}

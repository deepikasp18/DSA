package BinaryTree;

import java.util.*;

/*
Given a matrix mat[][], where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:  

0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges
Find the minimum time required so that all the oranges become rotten. A rotten orange at index (i,j) can rot other fresh oranges which are its neighbours (up, down, left, and right). Each rotten orange takes 1 unit of time to rot all its adjacent fresh oranges.

Note : If it is impossible to rot every orange then simply return -1.
*/
public class RottenOranges {
    public static void main(String[] args) {
        int[][] mat = {
            {2, 1, 0, 2, 1},
            {0, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}
        };

        System.out.println("Minimum time required to rot all oranges: " + minTimeToRotAllOranges(mat));
    }

    private static int minTimeToRotAllOranges(int[][] matrix) {
        int elapsedTime = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean changed;

        Queue<int[]> queue = new ArrayDeque<>();

        // Add all initially rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // Directions for adjacent cells (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            changed = false;

            // Process all rotten oranges in the current level
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];

                for (int[] dir: directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check if the new position is within bounds and has a fresh orange
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && matrix[newX][newY] == 1) {
                        // Rot the fresh orange
                        matrix[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                        changed = true;
                    }
                }
            }

            if (changed) {
                elapsedTime++;
            }
        }

        // Check if any fresh orange is left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    return -1; // Impossible to rot all oranges
                }
            }
        }

        return elapsedTime;
    }
}

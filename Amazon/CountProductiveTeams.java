package Amazon;

import java.time.Duration;
import java.time.Instant;

/**
 * You are given an integer array level of size n that is a permutation (i.e., all values are distinct, typically it contains 1..n). Count how many 4-person teams can be formed that satisfy a specific “productive” pattern.
Definitions
Permutation: level contains n distinct integers (commonly the numbers 1..n exactly once).
Team (size 4): choose indices (x, y, z, w) such that x < y < z < w (indices are 0-based).
Productive team condition: level[x] < level[z] and level[y] > level[w].
Task
Return the total number of productive teams (x, y, z, w) that satisfy:

x < y < z < w
level[x] < level[z]
level[y] > level[w]
Input / Output
Input: integer array level (a permutation), length n.
Output: an integer = number of productive teams of size 4.
 */
public class CountProductiveTeams {
    public static void main(String[] args) {
        int[] productivity = {1, 5, 2, 4, 3, 6, 8, 7, 10, 9, 12, 11, 14, 13}; // Example input
        int count = countProductiveTeams(productivity);
        System.out.println("Number of productive teams: " + count);
        int optimizedCount = countProductiveTeamsOptimized(productivity);
        System.out.println("Number of productive teams (Optimized): " + optimizedCount);
        int preComputedCount = countProductiveTeamsPreComputed(productivity);
        System.out.println("Number of productive teams (Precomputed): " + preComputedCount);
    }

    private static int countProductiveTeams(int[] level) {
        Instant start = Instant.now();
        int n = level.length;
        int count = 0;

        for (int x = 0; x < n - 3; x++) {
            for (int y = x + 1; y < n - 2; y++) {
                for (int z = y + 1; z < n - 1; z++) {
                    for (int w = z + 1; w < n; w++) {
                        if (level[x] < level[z] && level[y] > level[w]) {
                            count++;
                        }
                    }
                }
            }
        }

        Instant end = Instant.now();
        System.out.println("Time taken (Brute Force): " + Duration.between(start, end).toMillis() + " ms");
        return count;
    }

    private static int countProductiveTeamsOptimized(int[] level) {
        Instant start = Instant.now();
        int n = level.length;

        if (n < 4) return 0;

        int count = 0;

        for (int y = 1; y < n - 2; y++) {
            for (int z = y + 1; z < n - 1; z++) {
                    int leftLess = 0;
                    int rightGreater = 0;

                    for (int x = 0; x < y; x++) {
                        if (level[x] < level[z]) {
                            leftLess++;
                        }
                    }

                    for (int w = z + 1; w < n; w++) {
                        if (level[w] < level[y]) {
                            rightGreater++;
                        }
                    }

                    count += leftLess * rightGreater;
            }
        }

        Instant end = Instant.now();
        System.out.println("Time taken (Optimized): " + Duration.between(start, end).toMillis() + " ms");

        return count;
    }

    private static int countProductiveTeamsPreComputed(int[] level) {
        Instant start = Instant.now();
        int n = level.length;

        if (n < 4) return 0;

        int count = 0;

        // Precompute counts of elements less than a given value to the left and right
        int[][] leftCount = new int[n][n + 1];
        int[][] rightCount = new int[n][n + 1];

        for (int x=0; x < n; x++) {
            for (int val = 1; val <= n; val++) {
                // Precompute counts of elements less than a given value to the left
                // If level[x] < val, increment the count, else carry forward the previous count
                // This builds a prefix count array
                // leftCount[x][val] = number of elements < val in level[0..x]
                // x > 0 ? leftCount[x - 1][val] : 0 gives the count up to the previous index
                // (level[x] < val ? 1 : 0) adds 1 if the current element is less than val
                leftCount[x][val] = (x > 0 ? leftCount[x - 1][val] : 0) + (level[x] < val ? 1 : 0);
            }   
        }

        for (int w = n - 1; w >= 0; w--) {
            for (int val = 1; val <= n; val++) {
                rightCount[w][val] = (w < n - 1 ? rightCount[w + 1][val] : 0) + (level[w] < val ? 1 : 0);
            }
        }

        for (int y = 1; y < n - 2; y++) {
            for (int z = y + 1; z < n - 1; z++) {
                count += leftCount[y - 1][level[z]] * rightCount[z + 1][level[y]];
            }
        }

        Instant end = Instant.now();
        System.out.println("Time taken (Precomputed): " + Duration.between(start, end).toMillis() + " ms");

        return count;
    }
}

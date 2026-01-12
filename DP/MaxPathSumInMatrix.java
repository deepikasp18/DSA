package dp;

/*
    You are given a matrix mat[][] of size n x m where each element is a positive integer. Starting from any cell in the first row, you are allowed to move to the next row, but with specific movement constraints. From any cell (r, c) in the current row, you can move to any of the three possible positions :

(r+1, c-1) — move diagonally to the left.
(r+1, c) — move directly down.
(r+1, c+1) — move diagonally to the right.
Find the maximum sum of any path starting from any column in the first row and ending at any column in the last row, following the above movement constraints.
*/
public class MaxPathSumInMatrix {

    public static void main(String[] args) {
        int[][] mat = {
            {5,5},
            {3,10}
        };

        System.out.println("Maximum path sum in matrix: " + maximumPath(mat));
    }

    public static int maximumPath(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        int[][] dp = new int[rows][cols];
        
        System.arraycopy(mat[0], 0, dp[0], 0, cols);
        
        for (int i=1; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int k = 0, l, m=0;
                
                if (j-1 >= 0) {
                    k = dp[i-1][j-1];
                }
                
                l = dp[i-1][j];
                
                if (j+1 < cols) {
                    m = dp[i-1][j+1];
                }
            
                
                dp[i][j] = getMax(k,l,m) + mat[i][j];
            }
        }
        
        int maxPath=0;
        
        for (int j = 0; j<cols; j++) {
            maxPath = Math.max(maxPath, dp[rows-1][j]);
        }
        
        return maxPath;
    }
    
    private static int getMax(int a, int b, int c) {
        
        if ( a >= b && a>= c) {
            return a; 
        } else  if (b>=c && b>= a) {
            return b; 
        } else {
            return c;
        }
    }

}

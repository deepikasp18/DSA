package backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean exists = exist(board, word);
        System.out.println("Word " + word + " exists in board: " + exists);
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] != word.charAt(0)) {
                    continue;
                }
                if (backtrack(board, word, 0, r, c, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (isIndexValid(row, col, board) ||
                visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        // Explore all possible directions: up, down, left, right
        boolean found = backtrack(board, word, index + 1, row - 1, col, visited) ||
                        backtrack(board, word, index + 1, row + 1, col, visited) ||
                        backtrack(board, word, index + 1, row, col - 1, visited) ||
                        backtrack(board, word, index + 1, row, col + 1, visited);

        visited[row][col] = false; // backtrack
        return found;
    }

    private static boolean isIndexValid(int row, int col, char[][] board) {
        return row < 0 || row >= board.length || col < 0 || col >= board[0].length;
    }
}
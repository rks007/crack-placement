package twoDimensionalArrays;

public class wordSearch { //leetcode 79

    class Solution {
        public boolean exist(char[][] board, String word) {
            int row = board.length;      // Number of rows in the board
            int col = board[0].length;   // Number of columns in the board
            boolean[][] vis = new boolean[row][col]; // Visited array to keep track of visited cells

            // Iterate over each cell in the board
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // Start the search if the first character of the word matches the cell
                    if (board[i][j] == word.charAt(0) && search(i, j, 0, board, word, vis)) {
                        return true; // If the word is found, return true
                    }
                }
            }
            return false; // If the word is not found, return false
        }

        private boolean search(int i, int j, int idx, char[][] board, String word, boolean[][] vis) {
            // Check if the entire word is found
            if (word.length() == idx) {
                return true;
            }

            // Boundary check and check if the cell matches the current character in the word
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(idx) != board[i][j] || vis[i][j]) {
                return false;
            }

            // Mark the cell as visited
            vis[i][j] = true;

            // Explore all four possible directions (up, down, left, right)
            if (
                    search(i + 1, j, idx + 1, board, word, vis) || // Move down
                            search(i - 1, j, idx + 1, board, word, vis) || // Move up
                            search(i, j + 1, idx + 1, board, word, vis) || // Move right
                            search(i, j - 1, idx + 1, board, word, vis)    // Move left
            ) {
                return true; // If any direction finds the word, return true
            }

            // Unmark the cell as visited for backtracking
            vis[i][j] = false;
            return false; // If no direction finds the word, return false
        }
    }


}

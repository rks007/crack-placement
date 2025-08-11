package graph;

public class wordSearch { //leetcode 79
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j] && dfs(board, i , j, 0, vis, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int count, boolean[][] vis, String word){
        if(count == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(count) != board[i][j] || vis[i][j]){
            return false;
        }

        vis[i][j] = true;

        if(
                        dfs(board, i + 1, j, count + 1, vis, word) ||
                        dfs(board, i - 1, j, count + 1, vis, word) ||
                        dfs(board, i, j + 1, count + 1, vis, word) ||
                        dfs(board, i, j - 1, count + 1, vis, word)
        ){
            return true;
        }

        vis[i][j] = false;
        return false;
    }
}

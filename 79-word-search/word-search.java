class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;        
        
        if (m == 1 && n == 1  && word.length() == 1) {
            return board[0][0] == word.charAt(0);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = '#'; // Mark as visited
        
        // Explore all 4 directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (backtrack(board, word, r, c, index + 1)) {
                return true;
            }
        }
        board[i][j] = temp; // Backtrack and reset
        return false;
        
    }
    
}
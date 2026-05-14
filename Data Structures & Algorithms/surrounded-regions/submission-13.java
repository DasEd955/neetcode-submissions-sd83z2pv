class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == 'O' && (row == 0 || col == 0 || row == rows - 1 || col == cols - 1)) {
                    dfs(row, col, board);
                }
            }
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == 'O') {board[row][col] = 'X';}
                else if(board[row][col] == 'C') {board[row][col] = 'O';}
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'C';
        for(int[] dir : directions) {
            int nr = row + dir[0], nc = col + dir[1];
            dfs(nr, nc, board);
        }
    }
}

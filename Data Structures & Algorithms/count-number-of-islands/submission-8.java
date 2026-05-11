class Pair {
    public int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    bfs(row, col, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(int row, int col, char[][] grid) {
        Deque<Pair> queue = new ArrayDeque<>();
        grid[row][col] = '0';
        queue.offer(new Pair(row, col));

        while(!queue.isEmpty()) {
            Pair popped = queue.removeFirst();
            int r = popped.row, c = popped.col;
            for(int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == '0') {continue;}
                queue.offer(new Pair(nr, nc));
                grid[nr][nc] = '0';
            }
        }
    }
}

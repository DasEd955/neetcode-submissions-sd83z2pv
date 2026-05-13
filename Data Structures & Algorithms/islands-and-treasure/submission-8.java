class Pair {
    public int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {  
        int rows = grid.length, cols = grid[0].length;
        int inf = 2147483647;
        Deque<Pair> queue = new ArrayDeque<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 0) {queue.offer(new Pair(row, col));}
            }
        }

        while(!queue.isEmpty()) {
            Pair popped = queue.removeFirst();
            int row = popped.row, col = popped.col;
            for(int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == inf) {
                    grid[nr][nc] = grid[row][col] + 1;
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
    }
}

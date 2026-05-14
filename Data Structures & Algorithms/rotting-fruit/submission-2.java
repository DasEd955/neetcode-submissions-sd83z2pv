class Pair {
    public int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Deque<Pair> queue = new ArrayDeque<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 2) {queue.offer(new Pair(row, col));}
            }
        }

        int minutes = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                Pair popped = queue.removeFirst();
                int row = popped.row, col = popped.col;
                for(int[] dir : directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        queue.offer(new Pair(nr, nc));
                        grid[nr][nc] = 2;
                    }
                }
            }
            if(!queue.isEmpty()) {minutes++;}
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {return -1;}
            }
        }

        return minutes;
    }
}
class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        rows, cols = len(grid), len(grid[0])
        INF = 2147483647

        def bfs() -> None:
            queue = deque()
            
            for row in range(rows):
                for col in range(cols):
                    if grid[row][col] == 0:
                        queue.append((row, col))

            while queue:
                row, col = queue.popleft()
                
                for dr, dc in directions:
                    nr, nc = row + dr, col + dc
                    if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == INF:
                        grid[nr][nc] = grid[row][col] + 1
                        queue.append((nr, nc))
        
        bfs()
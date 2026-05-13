class Solution:
    def islandsAndTreasure(self, grid: list[list[int]]) -> None:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        rows, cols = len(grid), len(grid[0])
        visited = set()
        INF = 2147483647

        def dfs(row: int, col: int) -> int:
            if row < 0 or col < 0 or row >= rows or col >= cols or grid[row][col] == -1 or (row, col) in visited:
                return INF
            if grid[row][col] == 0:
                return 0

            visited.add((row, col))

            result = INF
            for dr, dc in directions:
                distance = dfs(row + dr, col + dc)
                if distance != INF:
                    result = min(result, 1 + distance)
            
            visited.remove((row, col))

            return result
        
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == INF:
                    grid[row][col] = dfs(row, col)
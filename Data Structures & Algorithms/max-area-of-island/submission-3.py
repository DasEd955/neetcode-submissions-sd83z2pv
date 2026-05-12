class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        visited = set()
        rows, cols = len(grid), len(grid[0])
        maxArea = 0

        def dfs(row: int, col: int) -> int:
            if row < 0 or col < 0 or row >= rows or col >= cols or grid[row][col] == 0 or (row, col) in visited:
                return 0
            
            visited.add((row, col))
            currentMax = 1
            for dr, dc in directions:
                currentMax += dfs(row + dr, col + dc)

            return currentMax

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 1:
                    maxArea = max(maxArea, dfs(row, col))
        
        return maxArea
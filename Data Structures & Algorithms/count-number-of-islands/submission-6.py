class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        seen = set()
        rows, cols = len(grid), len(grid[0])
        islands = 0

        def dfs(row: int, col: int) -> None:
            if row < 0 or col < 0 or row >= rows or col >= cols or grid[row][col] == "0" or (row, col) in seen:
                return
            
            seen.add((row, col))
            for dr, dc in directions:
                dfs(row + dr,col + dc)
        
        for row in range(rows):
            for col in range(cols):
                if (row, col) not in seen and grid[row][col] == "1":
                    dfs(row, col)
                    islands += 1
        
        return islands
        
class Solution:
    def pacificAtlantic(self, heights: list[list[int]]) -> list[list[int]]:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        rows, cols = len(heights), len(heights[0])
        atlantic, pacific = set(), set()

        def dfs(row: int, col: int, visited: set, prevHeight: int) -> None:
            if row < 0 or col < 0 or row >= rows or col >= cols or (row, col) in visited or heights[row][col] < prevHeight:
                return 
            
            visited.add((row, col))
            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                dfs(nr, nc, visited, heights[row][col])
            
        for row in range(rows):
            dfs(row, 0, pacific, heights[row][0])
            dfs(row, cols - 1, atlantic, heights[row][cols - 1])
        
        for col in range(cols):
            dfs(0, col, pacific, heights[0][col])
            dfs(rows - 1, col, atlantic, heights[rows - 1][col])
        
        return list(atlantic.intersection(pacific))
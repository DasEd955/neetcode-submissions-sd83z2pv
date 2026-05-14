class Solution:
    def solve(self, board: List[List[str]]) -> None:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        rows, cols = len(board), len(board[0])

        def dfs(row: int, col: int) -> None:
            if row < 0 or col < 0 or row >= rows or col >= cols or board[row][col] != 'O':
                return
            board[row][col] = 'C'
            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                dfs(nr, nc)
        
        for row in range(rows):
            for col in range(cols):
                if board[row][col] == 'O' and (row == 0 or col == 0 or row == rows - 1 or col == cols - 1):
                    dfs(row, col)
        
        for row in range(rows):
            for col in range(cols):
                if board[row][col] == 'O':
                    board[row][col] = 'X'
                elif board[row][col] == 'C':
                    board[row][col] = 'O'
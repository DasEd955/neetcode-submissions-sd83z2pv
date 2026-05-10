class TrieNode:
    def __init__(self):
        self.children = dict()
        self.isWord = False

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        foundWords = list()
        rows, cols = len(board), len(board[0])

        root = TrieNode()
        for word in words: 
            node = root
            for char in word:
                if char not in node.children:
                    node.children[char] = TrieNode()
                node = node.children[char]
            node.isWord = True

        def dfs(row: int, col: int, node: TrieNode, path: str) -> None:
            if row < 0 or col < 0 or row >= rows or col >= cols or board[row][col] == '#':
                return 
            char = board[row][col]
            if char not in node.children:
                return
            
            node = node.children[char]
            path += char

            if node.isWord:
                foundWords.append(path)
                node.isWord = False
            
            temp = board[row][col]
            board[row][col] = '#'
            
            dfs(row+1, col, node, path) 
            dfs(row-1, col, node, path) 
            dfs(row, col+1, node, path) 
            dfs(row, col-1, node, path)
            
            board[row][col] = temp
        
        for row in range(rows):
            for col in range(cols):
                dfs(row, col, root, "")
                
        return foundWords
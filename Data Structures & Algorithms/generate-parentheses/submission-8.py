class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        result, current = list(), list()

        def dfs(openCount: int, closeCount: int, index: int) -> None:
            if index == n * 2:
                result.append(''.join(current))
                return 
            
            if openCount < n:
                current.append('(')
                dfs(openCount+1, closeCount, index + 1)
                current.pop()

            if closeCount < openCount:
                current.append(')')
                dfs(openCount, closeCount+1, index + 1)
                current.pop()
            
        dfs(0, 0, 0)
        return result
        

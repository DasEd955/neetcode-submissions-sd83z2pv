class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) > n - 1:
            return False
        
        visited = set()
        neighbors = defaultdict(list)

        for edge in edges:
            neighbors[edge[0]].append(edge[1])
            neighbors[edge[1]].append(edge[0])
        
        def dfs(node: int, parent: int) -> bool:
            if node in visited:
                return False
            visited.add(node)
            for neighbor in neighbors[node]:
                if neighbor == parent:
                    continue
                if not dfs(neighbor, node):
                    return False
            return True
        
        return dfs(0, -1) and len(visited) == n
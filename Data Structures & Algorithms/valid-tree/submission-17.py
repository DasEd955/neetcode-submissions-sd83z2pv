class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False
        
        parent = [i for i in range(n)]
        rank = [1] * n

        def find(node: int) -> int:
            p = parent[node]
            while p != parent[p]:
                parent[p] = parent[parent[p]]
                p = parent[p]
            return p
        
        def union(node1: int, node2: int) -> bool:
            p1, p2 = find(node1), find(node2)
            if p1 == p2:
                return False
            if rank[p1] > rank[p2]:
                parent[p2] = p1
                rank[p1] += rank[p2]
            else:
                parent[p1] = p2
                rank[p2] += rank[p1]
            return True
        
        def components(n: int) -> int:
            components = n
            for node1, node2 in edges:
                if union(node1, node2):
                    components -= 1
                else:
                    return -1
            return components
        
        return components(n) == 1
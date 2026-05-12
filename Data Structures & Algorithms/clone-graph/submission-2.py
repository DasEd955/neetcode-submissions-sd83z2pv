"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        
        nodeMap = dict()

        def dfs(node: Optional['Node']) -> Optional['Node']:
            if node in nodeMap:
                return nodeMap[node]
            
            copyNode = Node(node.val)
            nodeMap[node] = copyNode

            for neighbor in node.neighbors:
                nodeMap[node].neighbors.append(dfs(neighbor))
            
            return copyNode
        
        return dfs(node)

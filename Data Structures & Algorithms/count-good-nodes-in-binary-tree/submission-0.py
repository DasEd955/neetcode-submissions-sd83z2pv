# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int: 
    
        if not root.left and not root.right:
            return 1
        
        def dfs(node: TreeNode, maxVal: int) -> int:

            if not node:
                return 0
            
            count = 1 if node.val >= maxVal else 0 
            maxVal = max(maxVal, node.val)
            left, right = dfs(node.left, maxVal), dfs(node.right, maxVal)
            count += left
            count += right 

            return count
        
        return dfs(root, root.val)
        
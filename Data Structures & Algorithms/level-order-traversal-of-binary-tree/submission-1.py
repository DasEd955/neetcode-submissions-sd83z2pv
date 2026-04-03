# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if not root:
            return []
        if not root.left and not root.right:
            return [[root.val]]
        
        result, queue = list(), collections.deque([root])

        while queue:
            level, levelSize = list(), len(queue)
            
            for i in range(levelSize):

                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                level.append(node.val)
                
            result.append(level)
        
        return result
        
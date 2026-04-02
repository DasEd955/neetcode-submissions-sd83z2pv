# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        if not root or not subRoot:
            return root is subRoot

        leftFound, rightFound = self.isSubtree(root.left, subRoot), self.isSubtree(root.right, subRoot)

        return self.sameTree(root, subRoot) or leftFound or rightFound
    
    def sameTree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        if not root or not subRoot:
            return root is subRoot

        leftMatch, rightMatch = self.sameTree(root.left, subRoot.left), self.sameTree(root.right, subRoot.right)

        return root.val == subRoot.val and leftMatch and rightMatch
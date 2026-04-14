# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:

        if not root:
            return str()

        result, queue = list(), deque([root])

        while queue:
            levelSize = len(queue)
            for _ in range(levelSize):
                node = queue.popleft()
                if node:
                    result.append(str(node.val))
                    queue.append(node.left)
                    queue.append(node.right)
                else:
                    result.append("N")
        
        return ','.join(result)
        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:

        if not data:
            return None
        
        values = [v for v in data.split(',') if v != '']
        root = TreeNode(int(values[0]))
        queue = deque([root])

        i = 1
        while queue and i < len(values):

            node = queue.popleft()

            if values[i] != 'N':
                node.left = TreeNode(int(values[i]))
                queue.append(node.left)
            i += 1

            if i < len(values) and values[i] != 'N':
                node.right = TreeNode(int(values[i]))
                queue.append(node.right)
            i += 1

        return root 


class TrieNode:
    def __init__(self):
        self.children = dict()
        self.isWord = False

class Solution:
    def longestCommonPrefix(self, strs: list[list[int]]) -> str:

        root = TrieNode()

        for string in strs:
            current = root
            for char in string:
                if char not in current.children:
                    current.children[char] = TrieNode()
                current = current.children[char]
            current.isWord = True
        
        current, prefix = root, str()
        while len(current.children) == 1 and current.isWord == False:
            key, val = next(iter(current.children.items()))
            prefix += key
            current = val
        
        return prefix

        
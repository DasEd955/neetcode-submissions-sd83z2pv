class TrieNode:
    def __init__(self):
        self.children = dict()
        self.isWord = False

class WordDictionary:
    
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        current = self.root
        for char in word:
            if char not in current.children:
                current.children[char] = TrieNode()
            current = current.children[char]
        current.isWord = True

    def search(self, word: str) -> bool:
        
        def dfs(node: TrieNode, index: int) -> bool:
            for i in range(index, len(word)):
                char = word[i]
                if char == '.':
                    for child in node.children.values():
                        if dfs(child, i + 1):
                            return True
                    return False
                else:
                    if char not in node.children:
                        return False
                    node = node.children[char]
            return node.isWord

        return dfs(self.root, 0)
        

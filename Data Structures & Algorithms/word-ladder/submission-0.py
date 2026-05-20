class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or beginWord == endWord:
            return 0

        words, result = set(wordList), 0
        queue = deque([beginWord])

        while queue:
            result += 1
            for _ in range(len(queue)):
                node = queue.popleft()
                if node == endWord:
                    return result
                for i in range(len(node)):
                    for c in range(97, 123):
                        if chr(c) == node[i]:
                            continue
                        neighbor = node[:i] + chr(c) + node[i + 1:]
                        if neighbor in words:
                            queue.append(neighbor)
                            words.remove(neighbor)
        
        return 0
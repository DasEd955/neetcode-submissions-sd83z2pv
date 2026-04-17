class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        
        for i in range(len(stones)):
            stones[i] *= -1

        heapq.heapify(stones)

        while len(stones) > 1:
            print(stones)
            x, y = heapq.heappop(stones), heapq.heappop(stones)
            if x == y:
                continue
            elif x < y:
                heapq.heappush(stones, (y - x) * -1)
        
        return stones[0] * -1 if stones else 0 
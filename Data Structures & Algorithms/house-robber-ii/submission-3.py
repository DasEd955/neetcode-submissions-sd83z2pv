class Solution:
    def rob(self, nums: List[int]) -> int:

        if len(nums) <= 1:
            return nums[0] if nums else 0
        
        def dfs(partition: list[int], i: int, cache: list[int]) -> int:
            if i >= len(partition):
                return 0
            if cache[i] != -1:
                return cache[i]
            rob = partition[i] + dfs(partition, i + 2, cache)
            skip = dfs(partition, i + 1, cache)
            cache[i] = max(rob, skip)
            return cache[i]
        
        cache1, cache2 = [-1] * (len(nums) - 1), [-1] * (len(nums) - 1)

        return max(dfs(nums[:-1], 0, cache1), dfs(nums[1:], 0, cache2))
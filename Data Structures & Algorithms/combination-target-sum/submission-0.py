class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:

        result, combo = list(), list()

        def dfs(index: int) -> None:
            if sum(combo) >= target or index >= len(nums):
                if sum(combo) == target:
                    result.append(combo.copy())
                return
            combo.append(nums[index])
            dfs(index)
            combo.pop()
            dfs(index + 1)
        
        dfs(0)
        return result
        
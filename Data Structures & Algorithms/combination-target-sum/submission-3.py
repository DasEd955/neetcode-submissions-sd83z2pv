class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        
        nums.sort()

        result, combo = list(), list()

        def dfs(index: int, combo: list[int], currSum: int) -> None:
            if currSum == target:
                result.append(combo.copy())
                return
            
            for j in range(index, len(nums)):
                if currSum + nums[j] > target:
                    return
                combo.append(nums[j])
                dfs(j, combo, currSum + nums[j])
                combo.pop()
        
        dfs(0, combo, 0)
        return result
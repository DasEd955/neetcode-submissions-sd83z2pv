class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:

        nums.sort()

        result, subset = list(), list()

        def dfs(index: int) -> None:
            result.append(subset.copy())
            
            for j in range(index, len(nums)):
                if j > index and nums[j] == nums[j - 1]:
                    continue
                subset.append(nums[j])
                dfs(j + 1)
                subset.pop()
        
        dfs(0)
        return result
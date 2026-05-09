class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        result = list()

        def dfs(index: int) -> None:
            if index == len(nums):
                result.append(nums[:])
                return
            for j in range(index, len(nums)):
                nums[index], nums[j] = nums[j], nums[index]
                dfs(index + 1)
                nums[index], nums[j] = nums[j], nums[index]
        
        dfs(0)
        return result
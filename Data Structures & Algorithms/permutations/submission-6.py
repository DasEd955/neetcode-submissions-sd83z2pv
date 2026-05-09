class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        result, permutation = list(), list()
        chosen = [False] * len(nums) 

        def dfs(permutation: list[int]):
            if len(permutation) == len(nums):
                result.append(permutation.copy())
                return
            
            for j in range(len(nums)):
                if not chosen[j]:
                    permutation.append(nums[j])
                    chosen[j] = True
                    dfs(permutation)
                    permutation.pop()
                    chosen[j] = False
        
        dfs(permutation)
        return result
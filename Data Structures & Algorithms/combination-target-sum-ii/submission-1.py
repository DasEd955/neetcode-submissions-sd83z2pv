class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()

        result, combo = list(), list()

        def dfs(index: int, combo: list[int], currSum: int) -> None:
            if currSum == target:
                result.append(combo.copy())
                return
            
            for j in range(index, len(candidates)):
                if currSum + candidates[j] > target:
                    return
                if j > index and candidates[j] == candidates[j - 1]:
                    continue
                combo.append(candidates[j])
                dfs(j + 1, combo, currSum + candidates[j])
                combo.pop()
            
        dfs(0, combo, 0)
        return result
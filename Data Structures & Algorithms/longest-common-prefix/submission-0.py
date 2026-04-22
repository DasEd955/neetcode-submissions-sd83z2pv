class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        
        for i in range(len(strs[0])):
            for string in strs:
                if i == len(string) or string[i] != strs[0][i]:
                    return strs[0][:i]
        return strs[0]
                
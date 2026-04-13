class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        seenNums = dict()

        for num in nums:
            seenNums[num] = 1 + seenNums.get(num, 0)
        
        inverted = {num: key for key, num in seenNums.items()}
        key = inverted.get(max(seenNums.values()))

        return key
        
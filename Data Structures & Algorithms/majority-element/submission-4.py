class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        seenNums = dict()
        result, maxCount = 0, 0

        for num in nums:
            seenNums[num] = 1 + seenNums.get(num, 0)

            if maxCount < seenNums[num]:
                result = num
                maxCount = seenNums[num]

        return result
        
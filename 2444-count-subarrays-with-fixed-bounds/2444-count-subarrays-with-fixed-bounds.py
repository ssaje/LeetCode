class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        lastInvalidIndex = -1
        lastMinIndex = -1
        lastMaxIndex = -1
        answer = 0
        for index, num in enumerate(nums):
            if not (minK <= num <= maxK): lastInvalidIndex = index
            if num == minK: lastMinIndex = index
            if num == maxK: lastMaxIndex = index

            minIndex = lastMinIndex if lastMinIndex < lastMaxIndex else lastMaxIndex
            diff = minIndex - lastInvalidIndex
            if diff > 0: answer += diff

        return answer
        
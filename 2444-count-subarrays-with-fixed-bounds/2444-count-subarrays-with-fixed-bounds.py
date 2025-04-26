class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        lastInvalidIndex = -1
        lastMinIndex = -1
        lastMaxIndex = -1
        answer = 0
        for index, num in enumerate(nums):
            if num < minK or num > maxK:
                lastInvalidIndex = index
            
            if num == minK:
                lastMinIndex = index
            
            if num == maxK:
                lastMaxIndex = index

            answer += max(0, min(lastMinIndex, lastMaxIndex) - lastInvalidIndex)

        return answer
        
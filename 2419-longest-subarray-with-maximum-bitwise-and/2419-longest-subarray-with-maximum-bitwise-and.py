class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        m = max(nums)
        l = -1
        answer = 0
        for r, num in enumerate(nums):
            if num != m:
                l = r
            else:
                answer = max(answer, r - l)

        return answer
class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        m = max(nums)
        l = 0
        answer = 0
        for r in range(len(nums)):
            if nums[r] != m:
                l = r
            else:
                answer = max(answer, r - l)

        return answer
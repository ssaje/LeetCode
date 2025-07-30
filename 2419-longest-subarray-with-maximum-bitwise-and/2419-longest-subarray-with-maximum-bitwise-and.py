from itertools import groupby

class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        m = max(nums)
        return max(
            len(list(group))
            for key, group in groupby(nums)
            if key == m
        )
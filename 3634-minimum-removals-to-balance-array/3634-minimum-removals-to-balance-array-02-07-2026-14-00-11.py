class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        arr = sorted(nums)
        left = 0
        for rv in arr:
            left += rv > arr[left] * k
        return left

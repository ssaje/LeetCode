class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total = sum(nums)
        if total % p == 0: return 0

        prefixSums = {0: -1}
        prefixSum = 0
        answer = len(nums)
        for index, num in enumerate(nums):
            prefixSum = (prefixSum + num) % p
            # total - S = 0 (mod p)
            # total = prefixSum - prefixSums[i] (mod p)
            # prefixSums[i] = prefixSum - total (mod p)

            key = (prefixSum - total + p) % p
            if key in prefixSums:
                answer = min(answer, index - prefixSums[key])

            prefixSums[prefixSum] = index

        return -1 if answer == len(nums) else answer
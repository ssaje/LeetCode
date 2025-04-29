class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        m = max(nums)
        r = 0
        counts = defaultdict(int)
        answer = 0
        for l in range(n):
            while r < n and counts[m] < k:
                counts[nums[r]] += 1
                r += 1
            
            if counts[m] >= k:
                answer += n - r + 1

            counts[nums[l]] -= 1

        return answer

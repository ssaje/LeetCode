class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        m = max(nums)
        r = 0
        count = 0
        answer = 0
        for l in range(n):
            while r < n and count < k:
                if nums[r] == m:
                    count += 1
                r += 1
            
            if count >= k:
                answer += n - r + 1

            if nums[l] == m:
                count -= 1

        return answer

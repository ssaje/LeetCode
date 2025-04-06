class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        max_count = 0
        max_index = 0

        dp = [0] * len(nums)
        prev = list(range(len(nums))) 
        sorted_nums = sorted(nums)
        for i, num in enumerate(sorted_nums):
            for j in range(i):
                if num % sorted_nums[j] != 0:
                    continue

                if dp[i] < dp[j]:
                    dp[i] = dp[j]
                    prev[i] = j

            dp[i] += 1
            if max_count < dp[i]:
                max_count = dp[i]
                max_index = i

        answer = [sorted_nums[max_index]]
        while max_index != prev[max_index]:
            max_index = prev[max_index]
            answer.append(sorted_nums[max_index])

        return answer
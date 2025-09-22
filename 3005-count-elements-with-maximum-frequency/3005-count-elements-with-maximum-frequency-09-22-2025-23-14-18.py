class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        counts = {}
        maximum = 0
        for num in nums:
            counts[num] = counts.get(num, 0) + 1
            maximum = max(maximum, counts[num])
        
        answer = 0
        for count in counts.values():
            if count == maximum:
                answer += maximum

        return answer
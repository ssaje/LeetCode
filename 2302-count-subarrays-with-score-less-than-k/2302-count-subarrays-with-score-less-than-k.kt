class Solution {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        var answer = 0L
        var s = 0
        var sum = 0L
        for (e in nums.indices) {
            sum += nums[e]
            while (sum * (e - s + 1) >= k) {
                sum -= nums[s++]
            }

            answer += e - s + 1
        }

        return answer
    }
}
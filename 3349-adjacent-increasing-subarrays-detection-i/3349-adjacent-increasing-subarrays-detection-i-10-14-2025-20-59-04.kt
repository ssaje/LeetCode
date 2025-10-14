class Solution {
    fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
        fun isIncreasing(s: Int): Boolean {
            var previous = -1001
            for (i in s..<s+k) {
                if (previous >= nums[i]) return false
                previous = nums[i]
            }

            return true
        }

        val n = nums.size
        for (i in 2*k..n) {
            if (isIncreasing(i - 2*k) && isIncreasing(i - k)) return true
        }

        return false
    }
}
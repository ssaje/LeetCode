class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 == 1) {
            return false
        }

        val dp = BooleanArray(total + 101)
        dp[0] = true
        var max = 0

        val limit = total / 2
        for (num in nums) {
            for (i in minOf(limit, max) downTo 0) {
                if (dp[i]) {
                    dp[i + num] = true
                    max = maxOf(max, i + num)
                }
            }

            if (dp[limit]) {
                return true
            }
        }

        return false
    }
}
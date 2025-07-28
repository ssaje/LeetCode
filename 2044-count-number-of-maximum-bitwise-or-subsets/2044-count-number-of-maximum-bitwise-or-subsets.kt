class Solution {
    fun countMaxOrSubsets(nums: IntArray): Int {
        // 2^17 = 131,072
        val dp = IntArray(1 shl 17)
        dp[0] = 1

        var max = 0
        for (num in nums) {
            for (i in max downTo 0) {
                dp[i or num] += dp[i]
            }

            max = max or num
        }

        return dp[max]
    }
}
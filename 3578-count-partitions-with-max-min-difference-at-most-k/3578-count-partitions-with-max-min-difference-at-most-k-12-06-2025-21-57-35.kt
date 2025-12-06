class Solution {
    fun countPartitions(nums: IntArray, k: Int): Int {
        val n = nums.size
        var dp = LongArray(n + 1)
        dp[0] = 1L

        val mins= ArrayDeque<Int>()
        val maxes = ArrayDeque<Int>()
        var minIndex = 0
        var sum = 0L
        for (i in 0..<n) {
            sum = (sum + dp[i]) % MOD

            val num = nums[i]
            while (mins.isNotEmpty() && nums[mins.last()] >= num) {
                mins.removeLast()
            }
            mins.addLast(i)

            while (maxes.isNotEmpty() && nums[maxes.last()] <= num) {
                maxes.removeLast()
            }
            maxes.addLast(i)

            while (mins.isNotEmpty() && maxes.isNotEmpty() && nums[maxes.first()] - nums[mins.first()] > k) {
                if (mins.first() == minIndex) mins.removeFirst()
                if (maxes.first() == minIndex) maxes.removeFirst()

                sum = (sum - dp[minIndex] + MOD) % MOD
                minIndex++
            }

            dp[i + 1] = sum
        }

        return dp[n].toInt()
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}
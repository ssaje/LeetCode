class Solution {
    fun numOfWays(n: Int): Int {
        val dp = Array(n) { LongArray(2) }
        dp[0][0] = 6
        dp[0][1] = 6

        for (i in 1..<n) {
            dp[i][0] = (dp[i - 1][0] * 3 + dp[i - 1][1] * 2) % MOD
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1] * 2) % MOD
        }

        return (dp[n - 1][0] + dp[n - 1][1]).toInt() % MOD
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
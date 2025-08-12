class Solution {
    fun numberOfWays(n: Int, x: Int): Int {
        val powers = mutableListOf<Int>()
        for (i in 1..n) {
            var power = 1
            for (j in 0..<x) {
                power *= i
                if (power > n) break
            }

            if (power > n) break

            powers += power
        }

        val m = powers.size
        val dp = IntArray(n + 1)
        dp[0] = 1
        for (power in powers) {
            for (i in n downTo power) {
                dp[i] = (dp[i - power] + dp[i]) % 1_000_000_007
            }
        }
        
        return dp[n]
    }
}
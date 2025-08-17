class Solution {
    fun new21Game(n: Int, k: Int, maxPts: Int): Double {
        if (k == 0) return 1.0

        val dp = DoubleArray(n + 1)
        dp[0] = 1.0

        var acc = 1.0
        for (i in 1..n) {
            if (i > maxPts && i <= k + maxPts) {
                acc -= dp[i - maxPts - 1]
            }

            dp[i] = acc / maxPts

            if (i < k) {
                acc += dp[i]
            }
        }

        var answer = 0.0
        for (i in k..n) {
            answer += dp[i]
        }

        return answer
    }
}
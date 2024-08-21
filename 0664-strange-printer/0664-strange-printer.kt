class Solution {
    fun strangePrinter(s: String): Int {
        val n = s.length
        val dp = Array(n) { IntArray(n) }
        for (i in 0..<n) {
            dp[i][i] = 1
        }

        for (diff in 1..<n) {
            for (i in 0..<n-diff) {
                val j = i + diff
                dp[i][j] = diff + 1
                for (k in i..<j) {
                    val delta = if (s[k] == s[j]) {
                        1
                    } else {
                        0
                    }

                    dp[i][j] = dp[i][j].coerceAtMost(dp[i][k] + dp[k + 1][j] - delta)
                }
            }
        }

        return dp[0][n - 1]
    }
}
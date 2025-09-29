class Solution {
    fun minScoreTriangulation(values: IntArray): Int {
        val n = values.size
        val dp = Array(n) { i -> IntArray(n) { j -> if (i > j || j - i < 2) 0 else 987654321 } }
        for (l in 2..<n) {
            for (i in 0..<n-l) {
                val j = i + l
                for (k in i+1..<j) {
                    dp[i][j] = minOf(
                        dp[i][j],
                        values[i] * values[k] * values[j] + dp[i][k] + dp[k][j],
                    )
                }
            }
        }

        return dp[0][n - 1]
    }
}
class Solution {
    fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { Array(n) { IntArray(k) } }
        dp[0][0][grid[0][0] % k] = 1

        for (i in 0..<m) {
            for (j in 0..<n) {
                for (rem in 0..<k) {
                    if (dp[i][j][rem] == -1) continue

                    if (i + 1 < m) {
                        val dRem = (rem + grid[i + 1][j]) % k
                        dp[i + 1][j][dRem] = (dp[i + 1][j][dRem] + dp[i][j][rem]) % MOD
                    }

                    if (j + 1 < n) {
                        val rRem = (rem + grid[i][j + 1]) % k
                        dp[i][j + 1][rRem] = (dp[i][j + 1][rRem] + dp[i][j][rem]) % MOD
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0]
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}
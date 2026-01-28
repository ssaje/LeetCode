class Solution {
    fun minCost(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size

        val orders = mutableListOf<IntArray>()
        for (i in 0..<m) {
            for (j in 0..<n) {
                orders += intArrayOf(i, j, grid[i][j])
            }
        }

        val dp = Array(m) { IntArray(n) { 987654321 } }
        dp[0][0] = 0
        
        val sorted = orders.sortedBy { it[2] }
        for (repeated in 0..k) {
            for (i in 0..<m) {
                for (j in 0..<n) {
                    if (i > 0) {
                        dp[i][j] = minOf(dp[i][j], dp[i - 1][j] + grid[i][j])
                    }

                    if (j > 0) {
                        dp[i][j] = minOf(dp[i][j], dp[i][j - 1] + grid[i][j])
                    }
                }
            }

            if (repeated == k) break

            val mins = IntArray(sorted.size + 1) { Int.MAX_VALUE }
            for (i in sorted.size-1 downTo 0) {
                val (x, y) = sorted[i]
                mins[i] = minOf(mins[i + 1], dp[x][y])
                if (i == 0 || sorted[i - 1][2] != sorted[i][2]) {
                    var j = i + 1
                    while (j < sorted.size && sorted[i][2] == sorted[j][2]) {
                        mins[j] = mins[i]
                        j++
                    }
                }
            }

            for (i in 0..<sorted.size) {
                val (x, y) = sorted[i]
                dp[x][y] = mins[i]
            }
        }

        return dp[m - 1][n - 1]
    }
}
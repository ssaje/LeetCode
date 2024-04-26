class Solution {
    fun minFallingPathSum(grid: Array<IntArray>): Int {
        val n = grid.size
        val d = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        for (j in grid[0].indices) {
            d[0][j] = grid[0][j]
        }

        for (i in 1..<n) {
            for (j in 0..<n) {
                for (k in 0..<n) {
                    if (k == j) {
                        continue
                    }

                    d[i][j] = d[i][j].coerceAtMost(d[i - 1][k])
                }

                d[i][j] += grid[i][j]
            }
        }

        return d.last().min()
    }
}
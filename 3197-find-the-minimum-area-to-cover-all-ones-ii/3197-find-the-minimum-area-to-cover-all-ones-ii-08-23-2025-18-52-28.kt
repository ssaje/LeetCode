class Solution {
    fun minimumSum(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val rotatedGrid = Array(m) { IntArray(n) }

        for (i in 0..<n) {
            for (j in 0..<m) {
                rotatedGrid[j][n - 1 - i] = grid[i][j]
            }
        }

        return minOf(minSum(grid), minSum(rotatedGrid))
    }

    private fun minSum(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        var answer = Int.MAX_VALUE
        for (i in 1..<n) {
            for (j in 1..<m) {
                answer = minOf(
                    answer,

                    minArea(grid, 0..<i, 0..<m) +
                    minArea(grid, i..<n, 0..<j) +
                    minArea(grid, i..<n, j..<m),

                    minArea(grid, 0..<i, 0..<j) +
                    minArea(grid, 0..<i, j..<m) +
                    minArea(grid, i..<n, 0..<m),
                )
            }
        }

        for (i in 0..<n-2) {
            for (j in i+1..<n-1) {
                answer = minOf(
                    answer,

                    minArea(grid, 0..i, 0..<m) +
                    minArea(grid, i+1..j, 0..<m) +
                    minArea(grid, j+1..<n, 0..<m),
                )
            }
        }

        return answer
    }

    private fun minArea(grid: Array<IntArray>, ud: IntRange, lr: IntRange): Int {
        var u = ud.endInclusive + 1
        var d = 0
        var l = lr.endInclusive + 1
        var r = 0
        for (i in ud) {
            for (j in lr) {
                if (grid[i][j] == 0) continue

                u = minOf(u, i)
                d = maxOf(d, i)
                l = minOf(l, j)
                r = maxOf(r, j)
            }
        }

        if (u > d) {
            return 900
        }

        return (d - u + 1) * (r - l + 1)
    }
}
class Solution {
    fun minimumArea(grid: Array<IntArray>): Int {
        val h = grid.indexOfLast { it.any { it == 1 } } - grid.indexOfFirst { it.any { it == 1 } } + 1
        var l = -1
        var r = -1

        val n = grid.size
        val m = grid[0].size
        outer@ for (j in 0..<m) {
            for (i in 0..<n) {
                if (grid[i][j] == 1) {
                    l = j
                    break@outer
                }
            }
        }

        outer@ for (j in m - 1 downTo 0) {
            for (i in 0..<n) {
                if (grid[i][j] == 1) {
                    r = j
                    break@outer
                }
            }
        }

        return h * (r - l + 1)
    }
}
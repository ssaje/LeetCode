class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size
        var a = 0
        val counts = IntArray(n * n + 1)
        for (i in 0..<n) {
            for (j in 0..<n) {
                val num = grid[i][j]
                if (++counts[num] == 2) {
                    a = num
                }
            }
        }

        for (i in 1..n*n) {
            if (counts[i] == 0) {
                return intArrayOf(a, i)
            }
        }

        return intArrayOf()
    }
}
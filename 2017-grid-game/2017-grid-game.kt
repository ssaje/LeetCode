class Solution {
    fun gridGame(grid: Array<IntArray>): Long {
        val n = grid[0].size

        var u = 0L
        for (i in 0..<n) {
            u += grid[0][i]
        }

        var answer = Long.MAX_VALUE
        var l = 0L
        for (i in 0..<n) {
            u -= grid[0][i]

            answer = minOf(
                answer,
                maxOf(u, l),
            )

            l += grid[1][i]
        }

        return answer
    }
}
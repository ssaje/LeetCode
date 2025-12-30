class Solution {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        fun isMaginSquare(row: Int, col: Int): Boolean {
            if (grid[row + 1][col + 1] != 5) return false

            val border = buildString {
                for (index in borderIndexes) {
                    append(grid[row + index / 3][col + index % 3])
                }
            }

            return grid[row][col] % 2 == 0 && (border in cw || border in ccw)
        }

        val n = grid.size
        val m = grid[0].size
        var answer = 0
        for (row in 0..<n-2) {
            for (col in 0..<m-2) {
                if (isMaginSquare(row, col)) {
                    answer++
                }
            }
        }

        return answer
    }

    companion object {
        private val cw = "2943816729438167"
        private val ccw = cw.reversed()
        private val borderIndexes = listOf(
            0, 1, 2, 5, 8, 7, 6, 3,
        )
    }
}
class Solution {
    fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val answer = Array(n) { IntArray(n) }
        for (i in 0..<n) {
            val diagonals = IntArray(n - i)
            for (j in 0..<n-i) {
                diagonals[j] = grid[i + j][j]
            }

            diagonals.sortedDescending().forEachIndexed { j, element ->
                answer[i + j][j] = element
            }
        }

        for (i in 1..<n) {
            val diagonals = IntArray(n - i)
            for (j in 0..<n-i) {
                diagonals[j] = grid[j][j + i]
            }

            diagonals.sorted().forEachIndexed { j, element ->
                answer[j][j + i] = element
            }
        }

        return answer
    }
}
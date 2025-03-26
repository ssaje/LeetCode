class Solution {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val cells = mutableListOf<Int>()
        val mod = grid[0][0] % x
        for (row in grid) {
            for (cell in row) {
                if (cell % x != mod) {
                    return -1
                }

                cells += cell
            }
        }

        val sorted = cells.sorted()
        var answer = 0
        for (cell in sorted) {
            answer += (cell - sorted[sorted.size / 2]).absoluteValue
        }

        return answer / x
    }
}
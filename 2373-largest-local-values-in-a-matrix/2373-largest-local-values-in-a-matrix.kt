class Solution {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val answer = Array(n - 2) { IntArray(n - 2) }

        for (i in 2..<n) {
            for (j in 2..<n) {
                var max = 0
                for (k in i-2..i) {
                    for (l in j-2..j) {
                        max = max.coerceAtLeast(grid[k][l])
                    }
                }

                answer[i - 2][j - 2] = max
            }
        }

        return answer
    }
}
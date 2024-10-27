class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val maxLengths = Array(m + 1) { IntArray(n + 1) }
        var answer = 0
        for (i in 1..m) {
            for (j in 1..n) {
                maxLengths[i][j] = minOf(maxLengths[i - 1][j], maxLengths[i - 1][j - 1], maxLengths[i][j - 1])
                if (matrix[i - 1][j - 1] == 1) {
                    maxLengths[i][j]++
                }

                answer += maxLengths[i][j]
            }
        }

        return answer
    }
}
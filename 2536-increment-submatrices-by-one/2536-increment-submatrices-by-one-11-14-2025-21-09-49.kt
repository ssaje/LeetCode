class Solution {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
        val diffs = Array(n + 1) { IntArray(n + 1) }
        for ((row1, col1, row2, col2) in queries) {
            for (row in row1..row2) {
                diffs[row][col1]++
                diffs[row][col2 + 1]--
            }
        }

        val answer = Array(n) { IntArray(n) }
        for (i in 0..<n) {
            var sum = 0
            for (j in 0..<n) {
                sum += diffs[i][j]
                answer[i][j] = sum
            }
        }

        return answer
    }
}
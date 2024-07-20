class Solution {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val m = rowSum.size
        val n = colSum.size

        val rows = IntArray(m) { rowSum[it] }
        val cols = IntArray(n) { colSum[it] }
        val matrix = Array(m) { IntArray(n) { 0 } }
        for (i in 0..<m) {
            for (j in 0..<n) {
                val min = min(rows[i], cols[j])
                matrix[i][j] = min
                rows[i] -= min
                cols[j] -= min
            }
        }

        return matrix
    }
}
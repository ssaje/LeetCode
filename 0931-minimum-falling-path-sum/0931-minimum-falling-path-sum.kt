class Solution {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val current = IntArray(matrix.size + 2) { matrix[0].getOrElse(it - 1) { 987654321 } }
        val next = IntArray(matrix.size)

        for (i in 1..matrix.lastIndex) {
            for (j in matrix[i].indices) {
                next[j] = min(current[j], min(current[j + 1], current[j + 2])) + matrix[i][j]
            }

            for (j in matrix[i].indices) {
                current[j + 1] = next[j]
            }
        }

        return current.minOf { it }
    }
}
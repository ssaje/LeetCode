class Solution {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val prefixSums = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }.apply {
            for (i in 1..matrix.size) {
                for (j in 1..matrix[0].size) {
                    this[i][j] = this[i - 1][j] + this[i][j - 1] - this[i - 1][j - 1] + matrix[i - 1][j - 1]
                }
            }
        }

        var answer = 0
        for (i1 in 1..matrix.size) {
            for (j1 in 1..matrix[0].size) {
                for (i2 in i1..matrix.size) {
                    for (j2 in j1..matrix[0].size) {
                        val sum = prefixSums[i2][j2] - prefixSums[i1 - 1][j2] - prefixSums[i2][j1 - 1] + prefixSums[i1 - 1][j1 - 1]
                        if (sum == target) {
                            ++answer
                        }
                    }
                }
            }
        }

        return answer
    }
}
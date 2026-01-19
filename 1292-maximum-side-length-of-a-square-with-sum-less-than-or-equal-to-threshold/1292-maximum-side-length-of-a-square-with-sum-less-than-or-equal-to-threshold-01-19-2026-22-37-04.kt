class Solution {
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        val m = mat.size
        val n = mat[0].size
        val prefixSums = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            for (j in 1..n) {
                prefixSums[i][j] = prefixSums[i - 1][j] + prefixSums[i][j - 1] - prefixSums[i - 1][j - 1] + mat[i - 1][j - 1]
            }
        }

        for (k in minOf(m, n) downTo 1) {
            for (i in k..m) {
                for (j in k..n) {
                    val sum = prefixSums[i][j] - prefixSums[i - k][j] - prefixSums[i][j - k] + prefixSums[i - k][j - k]
                    if (sum <= threshold) return k
                }
            }
        }

        return 0
    }
}
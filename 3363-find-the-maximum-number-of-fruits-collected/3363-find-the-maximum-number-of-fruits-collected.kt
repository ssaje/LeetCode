class Solution {
    fun maxCollectedFruits(fruits: Array<IntArray>): Int {
        val n = fruits.size
        var trace = 0

        for (i in 0..<n) {
            trace += fruits[i][i]
        }

        val upperDp = Array(n) { IntArray(n) }
        upperDp[0][n - 1] = fruits[0][n - 1]
        for (i in 1..<n) {
            for (j in maxOf(i+1, n-1-i)..<n) {
                upperDp[i][j] = maxOf(
                    upperDp[i - 1][j - 1],
                    upperDp[i - 1][j],
                    upperDp[i - 1].getOrNull(j + 1) ?: 0,
                )

                upperDp[i][j] += fruits[i][j]
            }
        }

        val lowerDp = Array(n) { IntArray(n) }
        lowerDp[n - 1][0] = fruits[n - 1][0]
        for (j in 1..<n) {
            for (i in maxOf(j+1, n-1-j)..<n) {
                lowerDp[i][j] = maxOf(
                    lowerDp[i - 1][j - 1],
                    lowerDp[i][j - 1],
                    lowerDp.getOrNull(i + 1)?.getOrNull(j - 1) ?: 0,
                )

                lowerDp[i][j] += fruits[i][j]
            }
        }

        return trace + upperDp[n - 2][n - 1] + lowerDp[n - 1][n - 2]
    }
}
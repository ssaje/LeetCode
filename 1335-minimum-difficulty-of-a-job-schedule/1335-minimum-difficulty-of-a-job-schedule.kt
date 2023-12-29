class Solution {
    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        val n = jobDifficulty.size
        if (n < d) {
            return -1
        }

        // D[i][j] := i일까지 j 작업을 처리했을 때 최소 어려움 (1-based)
        val D = Array(d + 1) { IntArray(n + 1) }
        for (j in 1..n) {
            D[1][j] = D[1][j - 1].coerceAtLeast(jobDifficulty[j - 1])
        }

        for (i in 2..d) {
            for (j in i..n) {
                D[i][j] = Int.MAX_VALUE

                var max = 0
                for (k in j downTo i) {
                    max = max.coerceAtLeast(jobDifficulty[k - 1])
                    D[i][j] = D[i][j].coerceAtMost(max + D[i - 1][k - 1])
                }
            }
        }

        return D[d][n]
    }
}
class Solution {
    companion object {
        private val MOD = 1000000007
    }

    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        if (n > target) {
            return 0
        }

        val D = Array(n + 1) { IntArray(target + 1) }
        for (i in 1..k.coerceAtMost(target)) {
            D[1][i] = 1
        }

        for (i in 2..n) {
            for (j in i..target) {
                val limit = (j-i+1).coerceAtMost(k)
                for (l in 1..limit) {
                    D[i][j] = (D[i][j] + D[i - 1][j - l]) % MOD
                }
            }
        }

        return D[n][target]
    }
}
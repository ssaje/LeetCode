class Solution {
    companion object {
        private const val MOD = 1_000_000_000 + 7
        private val cache = Array(1_001) { IntArray(1_001) { -1 } }.apply {
            this[1][0] = 1
            this[2][0] = 1
            this[2][1] = 1
        }
    }

    fun kInversePairs(n: Int, k: Int): Int {
        if (n < 1) {
            return 0
        } else if (cache[n][k] != -1) {
            return cache[n][k]
        }

        // d[n][k] = d[n - 1][k] + d[n - 1][k - 1] + d[n - 1][k - 2] + ... d[n - 1][k - n + 1]
        var sum = 0
        for (j in (k - n + 1).coerceAtLeast(0)..k) {
            sum = (sum + kInversePairs(n - 1, j)) % MOD
        }

        cache[n][k] = sum

        return sum
    }
}
class Solution {
    fun numTilings(n: Int): Int {
        val d = LongArray(n + 1)
        val e = LongArray(n + 1)
        d[0] = 1
        d[1] = 1

        for (i in 2..n) {
            d[i] = (d[i - 1] + d[i - 2] + e[i - 1] * 2) % MOD
            e[i] = (e[i - 1] + d[i - 2]) % MOD
        }

        return d[n].toInt()
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}
class Solution {
    fun countGoodNumbers(n: Long): Int {
        // odd: n / 2
        // even: (n + 1) / 2
        return ((power(5, (n + 1) / 2) * power(4, n / 2)) % MOD).toInt()
    }

    private fun power(base: Long, exp: Long): Long {
        var ret = 1L
        var b = base
        var e = exp
        while (e > 0) {
            if (e % 2 == 1L) {
                ret = (ret * b) % MOD
            }

            b = (b * b) % MOD
            e /= 2
        }

        return ret
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
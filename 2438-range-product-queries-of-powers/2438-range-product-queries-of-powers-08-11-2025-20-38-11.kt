class Solution {
    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        var powers = mutableListOf<Int>()
        var m = n
        var w = 1
        while (m > 0) {
            if (m % 2 == 1) {
                powers += w
            }

            w *= 2
            m /= 2
        }

        val products = LongArray(powers.size)
        products[0] = powers[0].toLong()
        for (i in 1..<powers.size) {
            products[i] = products[i - 1] * powers[i] % MOD
        }

        val answer = IntArray(queries.size)
        for (i in 0..<queries.size) {
            val (left, right) = queries[i]
            if (left == 0) {
                answer[i] = products[right].toInt()
            } else {
                answer[i] = (products[right] * pow(products[left - 1], MOD - 2) % MOD).toInt()
            }
        }

        return answer
    }

    private fun pow(a: Long, b: Int): Long {
        if (b == 0) return 1L
        else if (b % 2 == 1) return pow(a, b - 1) * a % MOD
        else {
            val half = pow(a, b / 2)
            return half * half % MOD
        }
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}
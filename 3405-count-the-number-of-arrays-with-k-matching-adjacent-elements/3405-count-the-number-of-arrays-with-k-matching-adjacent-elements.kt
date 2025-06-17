class Solution {
    fun countGoodArrays(n: Int, m: Int, k: Int): Int {      
        var answer = m * comb(n - 1, k) % MOD
        repeat(n - 1 - k) {
            answer = answer * (m - 1) % MOD
        }

        return answer.toInt()
    }

    private fun comb(n: Int, m: Int): Long {
        var ret = 1L
        var a = n
        var b = 1
        repeat(m) {            
            ret = ret * a % MOD
            ret = ret * pow(b, MOD - 2) % MOD
            a--
            b++
        }

        return ret
    }

    private fun pow(a: Int, b: Int): Long = if (b == 0) {
        1
    } else if (b % 2 == 0) {
        val half = pow(a, b / 2)
        half * half % MOD
    } else {
        a * pow(a, b - 1) % MOD
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
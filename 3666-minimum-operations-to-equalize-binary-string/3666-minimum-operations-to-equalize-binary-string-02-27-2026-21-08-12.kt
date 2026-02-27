class Solution {
    fun minOperations(s: String, k: Int): Int {
        val n = s.length
        val z = s.count { it == '0' }
        if (n == k) {
            return when {
                z == 0 -> 0
                z == n -> 1
                else -> -1
            }
        }

        var answer = Int.MAX_VALUE

        // i * k = z (mod 2)
        if (z % 2 == 0) {
            // i is even
            var i = maxOf(ceil(z, k), ceil(z, n - k))
            i += i % 2
            answer = i
        }

        if (z % 2 == k  % 2) {
            // i is odd
            var i = maxOf(ceil(z, k), ceil(n - z, n - k))
            i += if (i % 2 == 0) 1 else 0
            answer = minOf(answer, i)
        }

        return if (answer == Int.MAX_VALUE) -1 else answer
    }

    private fun ceil(a: Int, b: Int): Int = (a + b - 1) / b
}
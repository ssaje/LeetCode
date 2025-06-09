class Solution {
    fun findKthNumber(n: Int, k: Int): Int {
        var rest = k
        var prefix = 1
        while (rest > 1) {
            val count = prefixCount(n, prefix)
            if (count < rest) {
                rest -= count
                prefix++
            } else {
                rest--
                prefix *= 10
            }
        }

        return prefix
    }

    private fun prefixCount(n: Int, prefix: Int): Int {
        val limit = n + 1L
        var current = prefix.toLong()
        var next = current + 1
        var count = 0L
        while (current <= n) {
            count += next - current
            current *= 10
            next = minOf(next * 10, limit)
        }

        return count.toInt()
    }
}
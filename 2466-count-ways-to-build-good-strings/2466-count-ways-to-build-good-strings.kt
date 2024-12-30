class Solution {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val cache = IntArray(high + 1)
        cache[0] = 1

        for (i in 1..high) {
            if (i >= zero) {
                cache[i] = cache[i - zero]
            }

            if (i >= one) {
                cache[i] = (cache[i] + cache[i - one]) % 1_000_000_007
            }
        }

        return (cache.drop(low).sumOf { it.toLong() } % 1_000_000_007).toInt()
    }
}
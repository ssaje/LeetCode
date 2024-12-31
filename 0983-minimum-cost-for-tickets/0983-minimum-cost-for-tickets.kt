class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val cache = IntArray(365 + 1)
        val n = days.last()

        var j = 0
        for (i in 1..n) {
            while (i > days[j]) {
                j++
            }

            if (i < days[j]) {
                cache[i] = cache[i - 1]
                continue
            }

            cache[i] = minOf(
                costs[0] + cache[i - 1],
                costs[1] + cache.getOrElse(i - 7) { 0 },
                costs[2] + cache.getOrElse(i - 30) { 0 },
            )
        }

        return cache[n]
    }
}
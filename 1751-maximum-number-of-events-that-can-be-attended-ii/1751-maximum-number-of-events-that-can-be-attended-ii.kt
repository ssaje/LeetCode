class Solution {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        val sorted = events.sortedBy { it[0] }

        fun nextIndex(s: Int): Int {
            var l = 0
            var r = sorted.size
            while (l < r) {
                var m = l + (r - l) / 2
                if (sorted[m][0] <= s) {
                    l = m + 1
                } else {
                    r = m
                }
            }

            return l
        }

        val n = sorted.size
        var dp = IntArray(n + 1)
        repeat(k) {
            val next = IntArray(n + 1)
            for (i in n - 1 downTo 0) {
                val (s, e, v) = sorted[i]
                val j = nextIndex(e)
                next[i] = maxOf(next[i + 1], dp[j] + v)
            }

            dp = next
        }

        return dp[0]
    }
}
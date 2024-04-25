class Solution {
    fun longestIdealString(s: String, k: Int): Int {
        val d = mutableListOf<IntArray>(
            IntArray(26).apply {
                this[s[0] - 'a'] = 1
            }
        )

        for (i in 1..s.lastIndex) {
            d += IntArray(26)
            
            val c = s[i] - 'a'
            for (j in 0..<26) {
                if (j != c) {
                    d[i][j] = d[i - 1][j]
                    continue
                }

                val start = 0.coerceAtLeast(j - k)
                val end = 25.coerceAtMost(j + k)
                val max = d[i - 1]
                    .slice(start..end)
                    .max()

                d[i][j] = max + 1
            }
        }

        return d.last().max()
    }
}
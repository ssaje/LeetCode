class Solution {
    fun numWays(words: Array<String>, target: String): Int {
        val n = words[0].length
        val m = target.length
        val counts = Array(n) { mutableMapOf<Char, Int>() }

        for (i in 0..<n) {
            for (word in words) {
                val ch = word[i]
                counts[i][ch] = (counts[i][ch] ?: 0) + 1
            }
        }

        val cache = Array(n) { IntArray(m) { -1 } }
        fun solve(i: Int, j: Int): Int {
            if (j == m) {
                return 1
            } else if (i == n) {
                return 0
            } else if (cache[i][j] != -1) {
                return cache[i][j]
            }

            val ch = target[j]
            cache[i][j] = solve(i + 1, j)

            val count = counts[i][ch] ?: 0
            if (count > 0) {
                cache[i][j] = ((cache[i][j] + count.toLong() * solve(i + 1, j + 1)) % 1_000_000_007).toInt()
            }

            return cache[i][j]
        }

        return solve(0, 0)
    }
}
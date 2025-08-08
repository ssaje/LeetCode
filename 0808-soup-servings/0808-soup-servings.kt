class Solution {
    fun soupServings(n: Int): Double {
        val m = (n + 24) / 25
        val dp = mutableMapOf<Int, MutableMap<Int, Double>>()

        fun prob(i: Int, j: Int): Double {
            if (i <= 0 && j <= 0) return 0.5
            else if (i <= 0) return 1.0
            else if (j <= 0) return 0.0
            else if (i in dp && j in dp[i]!!) return dp[i]!![j]!!

            val sum = (prob(i - 4, j) + prob(i - 3, j - 1) + prob(i - 2, j - 2) + prob(i - 1, j - 3)) / 4
            dp.computeIfAbsent(i) { mutableMapOf() }[j] = sum
            return sum
        }
        
        for (s in 1..<m) {
            if (prob(s, s) > THRESHOLD) return 1.0
        }

        return prob(m, m)
    }

    companion object {
        private const val THRESHOLD = 1 - 1e-5
    }
}
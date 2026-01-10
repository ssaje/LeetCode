class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length
        val dp = Array(n) { IntArray(m) { -1 } }
        fun solve(i: Int, j: Int): Int {
            if (i == n && j == m) return 0
            if (i < n && j == m) return solve(i + 1, j) + s1[i].code
            if (i == n && j < m) return solve(i, j + 1) + s2[j].code
            if (dp[i][j] != -1) return dp[i][j]

            var m = minOf(solve(i + 1, j) + s1[i].code, solve(i, j + 1) + s2[j].code)
            if (s1[i] == s2[j]) {
                m = minOf(m, solve(i + 1, j + 1))
            }

            dp[i][j] = m

            return m
        }

        return solve(0, 0)
    }
}
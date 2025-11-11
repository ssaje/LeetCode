class Solution {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (str in strs) {
            val l0 = str.count { it == '0' }
            val l1 = str.length - l0
            for (i in m downTo l0) {
                for (j in n downTo l1) {
                    dp[i][j] = maxOf(dp[i][j], dp[i - l0][j - l1] + 1)
                }
            }
        }

        return dp[m][n]
    }
}
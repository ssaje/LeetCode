class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        val n = strs.size
        val m = strs[0].length

        fun isEverySorted(a: Int, b: Int): Boolean {
            for (i in 0..<n) {
                if (strs[i][a] > strs[i][b]) return false
            }

            return true
        }

        var answer = m - 1
        val dp = IntArray(m) { 1 }
        for (i in 1..<m) {
            for (j in 0..<i) {
                if (isEverySorted(j, i)) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }

            answer = minOf(answer, m - dp[i])
        }

        return answer
    }
}
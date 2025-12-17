class Solution {
    fun maximumProfit(prices: IntArray, k: Int): Long {
        val n = prices.size
        val dp = Array(n) { LongArray(k + 1) }
        var answer = 0L
        
        for (i in 1..<n) {
            for (j in 0..<i) {
                val diff = (prices[j] - prices[i]).absoluteValue
                for (l in 0..<k) {
                    val prev = if (j > 0) dp[j - 1][l] else 0L
                    dp[i][l + 1] = maxOf(dp[i - 1][l + 1], dp[i][l + 1], prev + diff)
                    answer = maxOf(answer, dp[i][l + 1])
                }
            }
        }

        return answer
    }
}
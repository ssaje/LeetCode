class Solution {
    fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
        val n = prices.size
        var total = 0L
        for (i in 0..<n) {
            total += prices[i] * strategy[i]
        }

        var sumOfProduct = 0L
        var sum = 0L
        var answer = total
        for (i in 0..<n) {
            sumOfProduct += prices[i] * strategy[i]
            sum += prices[i]

            if (i >= k / 2) {
                sum -= prices[i - k / 2]
            }

            if (i + 1 >= k) {
                answer = maxOf(answer, total - sumOfProduct + sum)
                sumOfProduct -= prices[i - k + 1] * strategy[i - k + 1]
            }
        }

        return answer
    }
}
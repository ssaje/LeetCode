class Solution {
    fun getDescentPeriods(prices: IntArray): Long {
        var previous = prices[0] + 1
        var count = 0
        var answer = 0L
        for (price in prices) {
            if (previous == price + 1) {
                count++
            } else {
                count = 1
            }

            answer += count
            previous = price
        }

        return answer
    }
}
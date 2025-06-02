class Solution {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        val candies = IntArray(n) { 1 }
        for (i in 1..<n) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1
            }
        }

        var answer = candies[n - 1]
        for (i in n-1 downTo 1) {
            if (ratings[i] < ratings[i - 1]) {
                candies[i - 1] = maxOf(candies[i] + 1, candies[i - 1])
            }

            answer += candies[i - 1]
        }

        return answer
    }
}
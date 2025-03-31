class Solution {
    fun putMarbles(weights: IntArray, k: Int): Long {
        val n = weights.size
        val sums = IntArray(n - 1) { weights[it] + weights[it + 1] }.sorted()
        var answer = 0L
        for (i in 0..<k-1) {
            answer += sums[n - 2 - i] - sums[i]
        }

        return answer
    }
}
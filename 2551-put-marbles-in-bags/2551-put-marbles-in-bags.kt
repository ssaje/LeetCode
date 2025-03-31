class Solution {
    fun putMarbles(weights: IntArray, k: Int): Long {
        val sums = IntArray(weights.size - 1) { weights[it] + weights[it + 1] }.sorted()
        var answer = 0L
        for (i in 0..<k-1) {
            answer += sums[weights.size - 2 - i] - sums[i]
        }

        return answer
    }
}
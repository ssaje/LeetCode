class Solution {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        var answer = 0
        var i = 0
        for (j in 1..values.lastIndex) {
            val delta = values[i] + i - j

            answer = answer.coerceAtLeast(values[j] + delta)

            if (delta < values[j]) {
                i = j
            }
        }

        return answer
    }
}
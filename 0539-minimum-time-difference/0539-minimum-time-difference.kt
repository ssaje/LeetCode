class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val sorted = timePoints.flatMap {
            val minutes = it.toMinutes()
            listOf(minutes, minutes + interval)
        }.sorted()

        var answer = interval
        for (i in 1..sorted.lastIndex) {
            answer = answer.coerceAtMost(sorted[i] - sorted[i - 1])
        }

        return answer
    }

    private fun String.toMinutes(): Int {
        return this.slice(0..1).toInt() * 60 + this.slice(3..4).toInt()
    }

    companion object {
        private const val interval = 24 * 60
    }
}
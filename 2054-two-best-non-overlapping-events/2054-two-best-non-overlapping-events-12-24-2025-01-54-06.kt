class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        val values = events.flatMap {
            listOf(
                intArrayOf(it[0], it[2], 0),
                intArrayOf(it[1], it[2], 1),
            )
        }.sortedWith(
            compareBy<IntArray> { it[0] }
                .thenBy { it[2] }
        )

        var answer = 0
        var maxValue = 0
        for ((time, value, type) in values) {
            if (type == 0) {
                answer = maxOf(answer, value + maxValue)
            } else {
                maxValue = maxOf(maxValue, value)
            }
        }

        return answer
    }
}
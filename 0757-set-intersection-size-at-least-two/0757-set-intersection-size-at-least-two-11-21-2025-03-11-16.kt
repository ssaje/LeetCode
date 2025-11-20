class Solution {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
        val sorted = intervals.sortedWith(
            compareBy<IntArray> { it[1] }
                .thenByDescending { it[0] }
        )

        var a = sorted[0][1] - 1
        var b = sorted[0][1]
        var answer = 2
        for (i in 1..<sorted.size) {
            val (s, e) = sorted[i]
            if (b < s) {
                answer += 2
                a = e - 1
                b = e
            } else if (a < s) {
                answer += 1
                a = b
                b = e
            }
        }

        return answer
    }
}
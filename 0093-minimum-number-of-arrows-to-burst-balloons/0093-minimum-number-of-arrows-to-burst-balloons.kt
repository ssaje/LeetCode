class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        val sorted = points.sortedBy { it[1] }
        var answer = 1
        var last = sorted[0][1]
        for (i in 1..sorted.lastIndex) {
            if (last < sorted[i][0]) {
                answer++
                last = sorted[i][1]
            }
        }

        return answer
    }
}
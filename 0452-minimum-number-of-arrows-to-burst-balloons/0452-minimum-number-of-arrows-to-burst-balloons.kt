class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        val sorted = points.sortedBy { it[1] }
        var answer = 0
        var last = 0
        while (last < sorted.size) {
            answer++

            var i = last
            while (i < sorted.size) {
                if (sorted[last][1] < sorted[i][0]) {
                    break
                }

                i++
            }

            last = i
        }

        return answer
    }
}
class Solution {
    fun numberOfPairs(points: Array<IntArray>): Int {
        var answer = 0
        for (i in 0..<points.size) {
            for (j in 0..<points.size) {
                if (j == i) continue
                if (points[i][0] > points[j][0] || points[i][1] < points[j][1]) continue

                answer++
                for (k in 0..<points.size) {
                    if (points[i][0] > points[k][0] || points[k][0] > points[j][0]) continue
                    if (points[i][1] < points[k][1] || points[k][1] < points[j][1]) continue
                    if (k == i || k == j) continue

                    answer--
                    break
                }
            }
        }

        return answer
    }
}
class Solution {
    fun maxPoints(points: Array<IntArray>): Long {
        val m = points.size
        val n = points[0].size

        val sums = Array(m) { LongArray(n) }
        for (j in points[0].indices) {
            sums[0][j] = points[0][j].toLong()
        }

        for (i in 1..<m) {
            var max = 0L
            for (j in 0..<n) {
                max--
                max = max.coerceAtLeast(sums[i - 1][j])
                sums[i][j] = max
            }

            max = 0L
            for (j in n-1 downTo 0) {
                max--
                max = max.coerceAtLeast(sums[i - 1][j])
                sums[i][j] = sums[i][j].coerceAtLeast(max) + points[i][j]
            }
        }

        var answer = 0L
        for (j in 0..<n) {
            answer = answer.coerceAtLeast(sums[m-1][j])
        }

        return answer
    }
}
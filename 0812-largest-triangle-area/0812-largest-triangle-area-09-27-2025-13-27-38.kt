class Solution {
    fun largestTriangleArea(points: Array<IntArray>): Double {
        fun hypot(i: Int, j: Int): Double {
            val dx = points[i][0] - points[j][0]
            val dy = points[i][1] - points[j][1]
            return hypot(dx.toDouble(), dy.toDouble())
        }

        val n = points.size
        var answer = 0.0
        for (i in 0..<n) {
            for (j in i+1..<n) {
                for (k in j+1..<n) {
                    val a = hypot(i, j)
                    val b = hypot(i, k)
                    val c = hypot(j, k)
                    val s = (a + b + c) / 2.0
                    answer = maxOf(answer, s * (s - a) * (s - b) * (s - c))
                }
            }
        }

        return sqrt(answer)
    }
}
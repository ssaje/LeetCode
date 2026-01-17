class Solution {
    fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
        fun commonArea(i: Int, j: Int): Long {
            val a = bottomLeft[i]
            val b = topRight[i]
            val c = bottomLeft[j]
            val d = topRight[j]

            if (d[0] <= a[0] || b[0] <= c[0]) return 0
            else if (d[1] <= a[1] || b[1] <= c[1]) return 0

            val w = minOf(b[0], d[0]) - maxOf(a[0], c[0])
            val h = minOf(b[1], d[1]) - maxOf(a[1], c[1])
            val s = minOf(w, h).toLong()
            return s * s
        }

        var answer = 0L
        val n = bottomLeft.size
        for (i in 0..<n) {
            for (j in i+1..<n) {
                answer = maxOf(answer, commonArea(i, j))
            }
        }

        return answer
    }
}
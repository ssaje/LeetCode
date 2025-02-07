class Solution {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val colors = mutableMapOf<Int, Int>()
        val counts = mutableMapOf<Int, Int>()
        var count = 0

        fun decolor(x: Int) {
            val color = colors[x] ?: 0
            if (color == 0) {
                return
            }

            val xCount = (counts[color] ?: 0) - 1
            colors[x] = 0
            counts[color] = xCount

            if (xCount == 0) {
                --count
            }
        }
        
        fun color(x: Int, y: Int): Int {
            val yCount = (counts[y] ?: 0) + 1
            colors[x] = y
            counts[y] = yCount

            return if (yCount == 1) {
                ++count
            } else {
                count
            }
        }

        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            val (x, y) = queries[i]
            decolor(x)
            answer[i] = color(x, y)
        }

        return answer
    }
}
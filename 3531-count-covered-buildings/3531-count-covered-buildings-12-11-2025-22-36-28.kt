class Solution {
    fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
        val minX = IntArray(n + 1) { n + 1 }
        val maxX = IntArray(n + 1)
        val minY = IntArray(n + 1) { n + 1 }
        val maxY = IntArray(n + 1)

        for ((x, y) in buildings) {
            minX[y] = minOf(minX[y], x)
            maxX[y] = maxOf(maxX[y], x)
            minY[x] = minOf(minY[x], y)
            maxY[x] = maxOf(maxY[x], y)
        }

        var answer = 0
        for ((x, y) in buildings) {
            if (minX[y] < x && x < maxX[y] && minY[x] < y && y < maxY[x]) {
                answer++
            }
        }

        return answer
    }
}
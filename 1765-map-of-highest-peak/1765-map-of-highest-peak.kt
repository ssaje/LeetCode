class Solution {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val m = isWater.size
        val n = isWater[0].size
        val heights = Array(m) { IntArray(n) { -1 } }

        val queue = ArrayDeque<Pair<Int, Int>>()
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (isWater[i][j] == 1) {
                    heights[i][j] = 0
                    queue.addFirst(i to j)
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()
            val nh = heights[i][j] + 1

            for ((di, dj) in dirs) {
                val ni = i + di
                if (ni < 0 || ni >= m) {
                    continue
                }

                val nj = j + dj
                if (nj < 0 || nj >= n) {
                    continue
                }

                if (heights[ni][nj] == -1) {
                    heights[ni][nj] = nh
                    queue.addLast(ni to nj)
                } else if (heights[ni][nj] > nh) {
                    heights[ni][nj] = nh
                }
            }
        }

        return heights
    }

    companion object {
        private val dirs = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    }
}
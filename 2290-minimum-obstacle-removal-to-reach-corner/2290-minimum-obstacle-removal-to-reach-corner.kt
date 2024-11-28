class Solution {
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val counts = IntArray(m * n) { 987654321 }
        val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }

        pq.offer(0 to 0)
        counts[0] = 0

        val goal = m * n - 1
        while (pq.isNotEmpty()) {
            val (u, count) = pq.poll()
            if (u == goal) {
                return count
            }

            val i = u / n
            val j = u % n
            for ((di, dj) in dirs) {
                val ni = di + i
                if (ni < 0 || ni >= m) {
                    continue
                }

                val nj = dj + j
                if (nj < 0 || nj >= n) {
                    continue
                }

                val v = ni * n + nj
                val nextCount = count + grid[ni][nj]
                if (counts[v] == 987654321) {
                    pq.offer(v to nextCount)
                }

                if (counts[v] > count + nextCount) {
                    counts[v] = count + nextCount
                }
            }
        }

        return counts[goal]
    }

    companion object {
        private val dirs = setOf(
            -1 to 0,
            0 to 1,
            1 to 0,
            0 to -1,
        )
    }
}
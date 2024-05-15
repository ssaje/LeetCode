class Solution {
    companion object {
        val dirs = listOf(
            -1 to 0,
            0 to 1,
            1 to 0,
            0 to -1,
        )
    }

    fun maximumSafenessFactor(grid: List<List<Int>>): Int {
        val n = grid.size
        val d = Array(n) { IntArray(n) { -1 } }
        val queue = ArrayDeque<Pair<Int, Int>>()

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    queue.addLast(i to j)
                    d[i][j] = 0
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()
            for ((di, dj) in dirs) {
                val ni = di + i
                val nj = dj + j
                if (ni !in 0..<n || nj !in 0..<n) {
                    continue
                }

                if (d[ni][nj] == -1) {
                    queue.addLast(ni to nj)
                    d[ni][nj] = d[i][j] + 1
                }
            }
        }

        val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b -> b.first - a.first }
        pq.offer(Triple(d[0][0], 0, 0))
        d[0][0] = -1

        while (pq.isNotEmpty()) {
            val (dist, i, j) = pq.poll()
            if (i + 1 == n && j + 1 == n) {
                return dist
            }

            for ((di, dj) in dirs) {
                val ni = di + i
                val nj = dj + j
                if (ni !in 0..<n || nj !in 0..<n) {
                    continue
                }

                if (d[ni][nj] == -1) {
                    continue
                }

                pq.offer(Triple(dist.coerceAtMost(d[ni][nj]), ni, nj))
                d[ni][nj] = -1
            }
        }

        return -1
    }
}
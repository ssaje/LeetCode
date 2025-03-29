class Solution {
    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) }

        val sorted = queries.withIndex().sortedBy { it.value }
        val pq = PriorityQueue<IntArray> { a, b -> a[0] - b[0] } // v, i, j
        pq.offer(intArrayOf(grid[0][0], 0, 0))
        visited[0][0] = true

        var acc = 0
        fun search(query: Int): Int {
            while (pq.isNotEmpty() && pq.peek()[0] < query) {
                acc++

                val (v, i, j) = pq.poll()
                for ((di, dj) in dirs) {
                    val ni = di + i
                    val nj = dj + j
                    if (ni !in 0..<m) {
                        continue
                    } else if (nj !in 0..<n) {
                        continue
                    } else if (visited[ni][nj]) {
                        continue
                    }

                    pq.offer(intArrayOf(grid[ni][nj], ni, nj))
                    visited[ni][nj] = true
                }
            }

            return acc
        }

        return sorted.asSequence().map { it.index to search(it.value) }.sortedBy { it.first }.map { it.second }.toList().toIntArray()
    }

    companion object {
        private val dirs = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    }
}
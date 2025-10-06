class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        // d, i, j
        val n = grid.size
        val pq = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }
        val dists = Array(n) { IntArray(n) { 987654321 } }
        
        pq.offer(intArrayOf(grid[0][0], 0, 0))
        dists[0][0] = grid[0][0]
        while (pq.isNotEmpty()) {
            val (d, i, j) = pq.poll()
            if (dists[i][j] < d) continue
            if (i == n - 1 && j == n - 1) return d

            for ((di, dj) in listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)) {
                val ni = i + di
                val nj = j + dj
                if (ni !in 0..<n || nj !in 0..<n) continue

                val nd = maxOf(d, grid[ni][nj])
                if (dists[ni][nj] > nd) {
                    dists[ni][nj] = nd
                    pq.offer(intArrayOf(nd, ni, nj))
                }
            }
        }

        return -1
    }
}
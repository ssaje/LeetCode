class Solution {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val m = heightMap.size
        val n = heightMap[0].size

        if (m <= 2 || n <= 2) {
            return 0
        }

        // (h, i, j)
        val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b -> a.first - b.first }
        val visited = Array(m) { BooleanArray(n) }
        
        for (i in 1..<m-1) {
            pq.offer(Triple(heightMap[i][0], i, 0))
            visited[i][0] = true

            pq.offer(Triple(heightMap[i][n-1], i, n-1))
            visited[i][n-1] = true
        }

        for (j in 1..<n-1) {
            pq.offer(Triple(heightMap[0][j], 0, j))
            visited[0][j] = true

            pq.offer(Triple(heightMap[m-1][j], m-1, j))
            visited[m-1][j] = true
        }

        visited[0][0] = true
        visited[0][n - 1] = true
        visited[m - 1][0] = true
        visited[m - 1][n - 1] = true

        var answer = 0
        while (pq.isNotEmpty()) {
            val (h, i, j) = pq.poll()

            for ((di, dj) in dirs) {
                val ni = i + di
                if (ni <= 0 || ni >= m) {
                    continue
                }

                val nj = j + dj
                if (nj <= 0 || nj >= n) {
                    continue
                }

                if (visited[ni][nj]) {
                    continue
                }

                var nh = heightMap[ni][nj]
                if (nh < h) {
                    answer += h - nh
                    nh = h
                }

                pq.offer(Triple(nh, ni, nj))
                visited[ni][nj] = true
            }
        }

        return answer
    }

    companion object {
        private val dirs = setOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    }
}
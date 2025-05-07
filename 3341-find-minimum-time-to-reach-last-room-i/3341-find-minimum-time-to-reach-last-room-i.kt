class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size
        val times = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        times[0][0] = 0

        // time, i, j
        val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b -> a.first.compareTo(b.first) }
        pq.offer(Triple(0, 0, 0))

        while (pq.isNotEmpty()) {
            val (time, i, j) = pq.poll()
            if (i == n - 1 && j == m - 1) {
                return time
            }

            if (time > times[i][j]) {
                continue
            }

            times[i][j] = time
            for ((di, dj) in dirs) {
                val ni = i + di
                val nj = j + dj
                if (ni !in 0..<n || nj !in 0..<m) {
                    continue
                }

                val nt = maxOf(time, moveTime[ni][nj]) + 1
                if (nt < times[ni][nj]) {
                    times[ni][nj] = nt
                    pq.offer(Triple(nt, ni, nj))
                }
            }
        }

        return -1
    }

    companion object {
        private val dirs = setOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    }
}
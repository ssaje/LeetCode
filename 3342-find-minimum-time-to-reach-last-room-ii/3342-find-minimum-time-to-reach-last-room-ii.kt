class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size
        val times = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        times[0][0] = 0

        // time, i, j, dt
        val pq = PriorityQueue<IntArray> { a, b -> a[0].compareTo(b[0]) }
        pq.offer(intArrayOf(0, 0, 0, 1))

        while (pq.isNotEmpty()) {
            val (time, i, j, dt) = pq.poll()
            if (time > times[i][j]) {
                continue
            }
            
            if (i == n - 1 && j == m - 1) {
                return time
            }

            times[i][j] = time
            for ((di, dj) in dirs) {
                val ni = i + di
                if (ni !in 0..<n) {
                    continue
                }

                val nj = j + dj
                if (nj !in 0..<m) {
                    continue
                }

                val nt = maxOf(time, moveTime[ni][nj]) + dt
                if (nt < times[ni][nj]) {
                    times[ni][nj] = nt
                    pq.offer(intArrayOf(nt, ni, nj, 3 - dt))
                }
            }
        }

        return -1
    }

    companion object {
        private val dirs = setOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    }
}
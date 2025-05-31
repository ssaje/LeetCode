class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }
        pq.offer(Pair(0, 1))

        fun pos(p: Int): Pair<Int, Int> {
            val i = n - 1 - (p - 1) / n
            val j = if ((p - 1) / n % 2 == 0) {
                (p - 1) % n
            } else {
                n - 1 - (p - 1) % n
            }

            return i to j
        }

        val dists = IntArray(n * n + 1) { Int.MAX_VALUE }
        while (pq.isNotEmpty()) {
            val (d, p) = pq.poll()
            if (dists[p] < d) continue

            for (k in 1..6) {
                if (p + k > n * n) break

                val m = p + k
                val (i, j) = pos(m)
                if (board[i][j] == -1) {
                    if (dists[m] > d + 1) {
                        pq.offer(d + 1 to m)
                        dists[m] = d + 1
                    }
                } else {
                    pq.offer(d + 1 to board[i][j])
                    if (dists[board[i][j]] > d + 1) {
                        pq.offer(d + 1 to board[i][j])
                        dists[board[i][j]] = d + 1
                    }
                }
            }
        }

        return if (dists[n * n] == Int.MAX_VALUE) -1 else dists[n * n]
    }
}
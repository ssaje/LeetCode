class Solution {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val graph = Array(n) { mutableMapOf<Int, Int>() }
        for ((u, v, time) in roads) {
            graph[u][v] = time
            graph[v][u] = time
        }

        val pq = PriorityQueue<Pair<Long, Int>> { a, b -> a.first.compareTo(b.first) } // dist, node
        pq.offer(0L to 0)

        val ways = IntArray(n)
        val dists = LongArray(n) { Long.MAX_VALUE }
        ways[0] = 1
        dists[0] = 0
        while (pq.isNotEmpty()) {
            val (d, u) = pq.poll()

            for ((v, time) in graph[u]) {
                val nd = d + time
                if (dists[v] > nd) {
                    dists[v] = nd
                    ways[v] = ways[u]
                    pq.offer(nd to v)
                } else if (dists[v] == nd) {
                    ways[v] = (ways[v] + ways[u]) % MOD
                }
            }
        }

        return ways[n - 1]
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}
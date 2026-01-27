class Solution {
    fun minCost(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<IntArray>() }
        for ((u, v, w) in edges) {
            graph[u] += intArrayOf(v, w)
            graph[v] += intArrayOf(u, 2*w)
        }

        val dists = IntArray(n) { -1 }
        val pq = RadixHeap()

        dists[0] = 0
        pq.offer(intArrayOf(0, 0))
        
        while (pq.isNotEmpty()) {
            val (d, u) = pq.poll()
            if (u == n - 1) return d
            else if (d > dists[u]) continue

            for ((v, w) in graph[u]) {
                val dist = d + w
                if (dists[v] == -1 || dists[v] > dist) {
                    dists[v] = dist
                    pq.offer(intArrayOf(dist, v))
                }
            }
        }

        return -1
    }

    private class RadixHeap {
        // dist, node
        private val buckets = Array(32) { mutableListOf<IntArray>() }
        private var last = 0
        private var size = 0

        fun isNotEmpty(): Boolean = size != 0

        fun offer(e: IntArray) {
            val i = bucketIndex(e[0])
            buckets[i].add(e)
            size++
        }

        fun poll(): IntArray {
            if (buckets[0].isEmpty()) {
                var i = 1
                while (i < 32 && buckets[i].isEmpty()) i++
                
                val bucket = buckets[i]
                last = bucket.minOf { it[0] }
                for (e in bucket) {
                    val j = bucketIndex(e[0])
                    buckets[j].add(e)
                }

                bucket.clear()
            }

            return buckets[0].removeLast().also { size-- }
        }

        private fun bucketIndex(dist: Int): Int {
            if (dist == last) return 0
            val xored = dist xor last
            return 32 - xored.countLeadingZeroBits()
        }
    }
}
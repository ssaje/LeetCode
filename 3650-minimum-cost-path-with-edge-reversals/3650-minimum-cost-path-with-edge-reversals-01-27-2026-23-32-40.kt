class Solution {
    fun minCost(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<IntArray>() }
        for ((u, v, w) in edges) {
            graph[u] += intArrayOf(v, w)
            graph[v] += intArrayOf(u, 2*w)
        }

        val dists = IntArray(n) { 987654321 }
        val pq = RadixHeap()

        dists[0] = 0
        pq.offer(intArrayOf(0, 0))
        
        while (pq.isNotEmpty()) {
            val (d, u) = pq.poll()
            if (u == n - 1) return d
            else if (d > dists[u]) continue

            for ((v, w) in graph[u]) {
                val dist = d + w
                if (dists[v] > dist) {
                    dists[v] = dist
                    pq.offer(intArrayOf(dist, v))
                }
            }
        }

        return -1
    }

    private class RadixHeap {
        // dist, node
        private val buckets = Array(33) { mutableListOf<IntArray>() }
        private val mins = Array(33) { Int.MAX_VALUE }
        private var last = 0
        private var size = 0

        fun isNotEmpty(): Boolean = size != 0

        fun offer(e: IntArray) {
            val d = e[0]
            val i = bucketIndex(d)
            buckets[i].add(e)
            mins[i] = minOf(mins[i], d)
            size++
        }

        fun poll(): IntArray {
            if (buckets[0].isEmpty()) {
                var i = 1
                while (i < 32 && buckets[i].isEmpty()) i++
                
                val bucket = buckets[i]
                last = mins[i]
                for (e in bucket) {
                    val d = e[0]
                    val j = bucketIndex(d)
                    buckets[j].add(e)
                    mins[j] = minOf(mins[j], d)
                }

                bucket.clear()
                mins[i] = Int.MAX_VALUE
            }

            return buckets[0].removeLast().also { size-- }
        }

        private fun bucketIndex(d: Int): Int {
            if (d == last) return 0
            val xored = d xor last
            return 32 - xored.countLeadingZeroBits()
        }
    }
}
class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val pq = PriorityQueue<Pair<Int, Double>> { a, b -> b.second.compareTo(a.second) }
        val visited = BooleanArray(n)

        pq.offer(start_node to 1.0)
        visited[start_node] = true

        val graph = Array(n) { mutableMapOf<Int, Double>() }
        for (i in edges.indices) {
            val (a, b) = edges[i]
            val prob = succProb[i]
            graph[a][b] = prob
            graph[b][a] = prob
        }

        while(pq.isNotEmpty()) {
            val (u, prob) = pq.poll()
            if (u == end_node) {
                return prob
            }

            visited[u] = true

            for ((v, weight) in graph[u]) {
                if (visited[v]) {
                    continue
                }

                val nextProb = prob * weight
                pq.offer(v to nextProb)
            }
        }

        return 0.0
    }
}
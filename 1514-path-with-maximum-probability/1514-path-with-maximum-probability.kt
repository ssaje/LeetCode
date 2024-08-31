class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val pq = PriorityQueue<Pair<Int, Double>> { a, b -> b.second.compareTo(a.second) }
        val probs = DoubleArray(n)

        pq.offer(start_node to 1.0)
        probs[start_node] = 1.0

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

            for ((v, weight) in graph[u]) {
                val nextProb = prob * weight
                if (probs[v] < nextProb) {
                    pq.offer(v to nextProb)
                    probs[v] = nextProb
                }
            }
        }

        return 0.0
    }
}
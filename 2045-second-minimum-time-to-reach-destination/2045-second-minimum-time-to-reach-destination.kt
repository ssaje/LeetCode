class Solution {
    fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            graph[u] += v
            graph[v] += u
        }

        val dists = Array(n + 1) { IntArray(2) { Int.MAX_VALUE } }
        val queue = ArrayDeque<Pair<Int, Int>>()
        
        queue.addLast(1 to 0)
        dists[1][0] = 0

        while (queue.isNotEmpty()) {
            val (u, nth) = queue.removeFirst()
            val dist = dists[u][nth]
                .let {
                    if (it / change % 2 == 0) {
                        it
                    } else {
                        (it / change + 1) * change
                    }
                }
                .plus(time)

            for (v in graph[u]) {
                if (dists[v][0] > dist) {
                    dists[v][1] = dists[v][0]
                    dists[v][0] = dist
                    
                    queue.addLast(v to 0)
                } else if (dists[v][1] > dist && dists[v][0] != dist) {
                    if (v == n) {
                        return dist
                    }

                    dists[v][1] = dist
                    
                    queue.addLast(v to 1)
                }
            }
        }

        return -1
    }
}
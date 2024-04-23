class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val graph = Array(n) { mutableListOf<Int>() }
        val degs = IntArray(n)

        for ((a, b) in edges) {
            graph[a].add(b)
            graph[b].add(a)

            degs[a]++
            degs[b]++
        }

        val queue = ArrayDeque<Int>()
        repeat(n) { node ->
            if (degs[node] == 1) {
                queue.addLast(node)
            }
        }

        var total = n
        while (total > 2) {
            val count = queue.size
            
            total -= count
            repeat(count) {
                val u = queue.removeFirst()
                for (v in graph[u]) {
                    if (--degs[v] == 1) {
                        queue.addLast(v)
                    }
                }
            }
        }

        return queue.toList()
    }
}
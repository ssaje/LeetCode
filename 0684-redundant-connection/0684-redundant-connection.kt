class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size

        fun buildGraph(exclude: Int): Array<MutableSet<Int>> {
            val graph = Array(n + 1) { mutableSetOf<Int>() }
            for (i in edges.indices) {
                if (i == exclude) {
                    continue
                }

                val (a, b) = edges[i]

                graph[a] += b
                graph[b] += a
            }

            return graph
        }

        for (i in n-1 downTo 0) {
            val graph = buildGraph(i)
            val visited = BooleanArray(n + 1)

            val size = dfs(graph, visited, 1)
            if (size == n) {
                return edges[i]
            }
        }

        return intArrayOf()
    }

    private fun dfs(graph: Array<MutableSet<Int>>, visited: BooleanArray, u: Int): Int {
        var size = 1
        visited[u] = true

        for (v in graph[u]) {
            if (visited[v]) {
                continue
            }

            size += dfs(graph, visited, v)
        }

        return size
    }
}
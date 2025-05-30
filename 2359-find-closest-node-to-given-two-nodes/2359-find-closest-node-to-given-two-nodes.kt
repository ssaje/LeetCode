class Solution {
    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        val n = edges.size
        val graph = Array(n) { mutableSetOf<Int>() }
        for (i in edges.indices) {
            if (edges[i] != -1) {
                graph[i] += edges[i]
            }
        }

        val dists1 = IntArray(n) { -1 }
        fun dfs1(u: Int, d: Int) {
            dists1[u] = d
            for (v in graph[u]) {
                if (dists1[v] == -1) {
                    dfs1(v, d + 1)
                }
            }
        }
        dfs1(node1, 0)

        val dists2 = IntArray(n) { -1 }
        fun dfs2(u: Int, d: Int) {
            dists2[u] = d
            for (v in graph[u]) {
                if (dists2[v] == -1) {
                    dfs2(v, d + 1)
                }
            }
        }
        dfs2(node2, 0)

        var answer = -1
        var min = Int.MAX_VALUE
        for (i in 0..<n) {
            if (dists1[i] == -1 || dists2[i] == -1) continue
            
            val max = maxOf(dists1[i], dists2[i])
            if (min > max) {
                min = max
                answer = i
            }
        }

        return answer
    }
}
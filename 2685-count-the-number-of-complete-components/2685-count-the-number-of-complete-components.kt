class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val counts = IntArray(n)
        val groups = IntArray(n) { -1 }

        val graph = Array(n) { mutableSetOf<Int>() }
        for ((a, b) in edges) {
            graph[a] += b
            graph[b] += a
        }

        var groupSize = 0
        fun dfs(u: Int) {
            counts[groupSize]++
            groups[u] = groupSize

            for (v in graph[u]) {
                if (groups[v] == -1) {
                    dfs(v)
                }
            }
        }

        for (i in 0..<n) {
            if (groups[i] == -1) {
                dfs(i)
                groupSize++
            }
        }

        val edgeCounts = IntArray(groupSize)
        for (i in 0..<n) {
            edgeCounts[groups[i]] += graph[i].size
        }

        var answer = 0
        for (i in 0..<groupSize) {
            if (edgeCounts[i] == counts[i] * (counts[i] - 1)) {
                answer++
            }
        }

        return answer
    }
}
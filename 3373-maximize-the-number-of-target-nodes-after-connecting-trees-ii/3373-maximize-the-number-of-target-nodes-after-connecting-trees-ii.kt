class Solution {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
        val n = edges1.size + 1
        val m = edges2.size + 1
        val colors1 = IntArray(n)
        val colors2 = IntArray(m)
        val graph1 = Array(n) { mutableSetOf<Int>() }
        val graph2 = Array(m) { mutableSetOf<Int>() }

        for ((a, b) in edges1) {
            graph1[a] += b
            graph1[b] += a
        }

        for ((u, v) in edges2) {
            graph2[u] += v
            graph2[v] += u
        }

        dfs(graph1, colors1, 0)
        dfs(graph2, colors2, 0)

        val counts1 = IntArray(3)
        val counts2 = IntArray(3)
        for (color in colors1) {
            counts1[color]++
        }

        for (color in colors2) {
            counts2[color]++
        }

        val max = counts2.max()
        val answer = IntArray(n) { max }
        for (i in 0..<n) {
            answer[i] += counts1[colors1[i]]
        }

        return answer
    }

    private fun dfs(graph: Array<MutableSet<Int>>, colors: IntArray, u: Int, color: Int = 1) {
        if (colors[u] != 0) return

        colors[u] = color

        for (v in graph[u]) {
            if (colors[v] == 0) {
                dfs(graph, colors, v, 3 - color)
            }
        }
    }
}
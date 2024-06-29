class Solution {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val g = Array<MutableList<Int>>(n) { mutableListOf() }
        for ((from, to) in edges) {
            g[to] = (g[to] ?: mutableListOf())
            g[to] += from
        }

        val answer = mutableMapOf<Int, List<Int>>()
        fun dfs(u: Int) {
            if (answer[u] != null) {
                return
            }

            answer[u] = buildList {
                for (v in g[u]) {
                    dfs(v)

                    add(v)
                    addAll(answer.getValue(v))
                }
            }.sorted().distinct()
        }

        for (node in 0..<n) {
            dfs(node)
        }

        return buildList {
            for (i in 0..<n) {
                add(answer.getValue(i))
            }
        }
    }
}
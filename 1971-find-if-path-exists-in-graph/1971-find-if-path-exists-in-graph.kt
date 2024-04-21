class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val visited = BooleanArray(n)
        val graph = Array(n) { HashSet<Int>() }
        
        edges.forEach { (u, v) ->
            graph[u].add(v)
            graph[v].add(u)
        }

        fun dfs(u: Int): Boolean {
            visited[u] = true
            if (u == destination) {
                return true
            }

            return graph[u].any {
                if (visited[it]) {
                    false
                } else {
                    dfs(it)
                }
            }
        }
        
        return dfs(source)
    }
}
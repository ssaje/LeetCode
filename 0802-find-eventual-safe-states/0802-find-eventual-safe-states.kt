class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val states = IntArray(n)
        val answer = mutableSetOf<Int>()

        fun dfs(u: Int): Boolean {
            states[u] = 1

            var isSafe = true
            for (v in graph[u]) {
                if (states[v] == 0) {
                    if (!dfs(v)) {
                        isSafe = false
                    }
                } else if (states[v] == 1) {
                    isSafe = false  
                } else {
                    if (v !in answer) {
                        isSafe = false
                    }
                }
            }

            states[u] = 2
            if (isSafe) {
                answer += u
            }

            return isSafe
        }

        for (u in 0..<n) {
            if (states[u] == 0) {
                dfs(u)
            }
        }

        return answer.sorted()
    }
}
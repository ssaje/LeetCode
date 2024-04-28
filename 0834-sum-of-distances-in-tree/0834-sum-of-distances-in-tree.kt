class Solution {
    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        val answer = IntArray(n)
        val counts = IntArray(n) { 1 }
        val sums = IntArray(n)

        val adj = Array(n) { mutableSetOf<Int>() }
        for ((u, v) in edges) {
            adj[u].add(v)
            adj[v].add(u)
        }

        fun getSubtree(u: Int, p: Int = -1) {
            for (v in adj[u]) {
                if (v == p) {
                    continue
                }

                getSubtree(v, u)

                counts[u] += counts[v]
                sums[u] += sums[v] + counts[v]
            }
        }

        fun solve(u: Int, p: Int = -1, acc: Int = 0) {
            answer[u] = sums[u] + acc
            for (v in adj[u]) {
                if (v == p) {
                    continue
                }

                solve(v, u, sums[u] - (sums[v] + counts[v]) + (counts[u] - counts[v]) + (acc + counts[0] - counts[u]))
            }
        }

        getSubtree(0)
        solve(0)

        return answer
    }
}
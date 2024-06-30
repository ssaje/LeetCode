class Solution {
    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        val e = Array(3) { mutableListOf<IntArray>() }
        for (edge in edges) {
            e[edge[0] - 1] += edge
        }

        val parents = Array(3) { IntArray(n + 1) { it } }
        val sizes = IntArray(3)
        
        fun getRoot(type: Int, u: Int): Int {
            if (parents[type][u] == u) {
                return u
            }

            parents[type][u] = getRoot(type, parents[type][u])
            return parents[type][u]
        }

        fun merge(edge: IntArray) {
            val (_, u, v) = edge
            val type = edge[0] - 1
            val uRoot = getRoot(type, u)
            val vRoot = getRoot(type, v)

            if (uRoot == vRoot) {
                return
            }

            parents[type][vRoot] = uRoot
            sizes[type]++
        }

        e[2].forEach(::merge)

        if (sizes[2] == n - 1) {
            return n - 1
        }

        for (i in 1..n) {
            parents[0][i] = parents[2][i]
            parents[1][i] = parents[2][i]
        }

        e[0].forEach(::merge)
        e[1].forEach(::merge)

        if (sizes[0] + sizes[2] != n - 1) {
            return -1
        }

        if (sizes[1] + sizes[2] != n - 1) {
            return -1
        }

        return edges.size - sizes.sum()
    }
}
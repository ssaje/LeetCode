class Solution {
    fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val groups = IntArray(n) { it }
        val values = IntArray(n) { -1 }

        fun root(u: Int): Int {
            if (groups[u] == u) {
                return u
            }

            groups[u] = root(groups[u])

            return groups[u]
        }

        fun merge(u: Int, v: Int, w: Int) {
            val ru = root(u)
            val rv = root(v)

            var nw = w
            if (ru != rv) {
                groups[rv] = ru
                nw = nw and values[rv]
            }

            if (values[ru] == -1) {
                values[ru] = nw
            } else {
                values[ru] = values[ru] and nw
            }
        }

        for ((u, v, w) in edges) {
            merge(u, v, w)
        }

        return query.map { (s, t) ->
            if (root(s) == root(t)) {
                values[root(s)]
            } else {
                -1
            }
        }.toIntArray()
    }
}
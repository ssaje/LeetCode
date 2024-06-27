class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        val degs = mutableMapOf<Int, Int>()
        for ((u, v) in edges) {
            degs[u] = (degs[u] ?: 0) + 1
            degs[v] = (degs[v] ?: 0) + 1
        }

        for ((node, deg) in degs) {
            if (deg > 1) {
                return node
            }
        }

        return 0
    }
}
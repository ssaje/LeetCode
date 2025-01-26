class Solution {
    fun maximumInvitations(favorite: IntArray): Int {
        val n = favorite.size
        val indegs = IntArray(n)

        for (u in 0..<n) {
            indegs[favorite[u]]++
        }

        val queue = ArrayDeque<Int>()
        for (u in 0..<n) {
            if (indegs[u] == 0) {
                queue.addLast(u)
            }
        }

        val maxSizes = IntArray(n)
        var size = 1
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val u = queue.removeFirst()
                val v = favorite[u]
                maxSizes[v] = maxSizes[v].coerceAtLeast(size)

                if (--indegs[v] == 0) {
                    queue.addLast(v)
                }
            }

            size++
        }

        var acyclic = 0
        for (u in 0..<n) {
            if (indegs[u] == 0) {
                continue
            }

            val v = favorite[u]
            if (favorite[v] == u) {
                indegs[u] = 0
                indegs[v] = 0
                acyclic += 2 + maxSizes[u] + maxSizes[v]
            }
        }

        var cyclic = 0
        fun dfs(u: Int, size: Int) {
            indegs[u] = 0

            val v = favorite[u]
            if (indegs[v] == 0) {
                cyclic = cyclic.coerceAtLeast(size)
                return
            }

            dfs(v, size + 1)
        }

        for (u in 0..<n) {
            if (indegs[u] > 0) {
                dfs(u, 1)
            }
        }

        return max(acyclic, cyclic)
    }
}
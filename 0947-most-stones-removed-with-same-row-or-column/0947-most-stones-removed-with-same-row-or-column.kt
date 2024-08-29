class Solution {
    fun removeStones(stones: Array<IntArray>): Int {        
        val n = stones.size
        val group = IntArray(n) { it }
        var count = n
        
        fun getRoot(u: Int): Int {
            if (u == group[u]) {
                return u
            }

            group[u] = getRoot(group[u])

            return group[u]
        }

        fun union(u: Int, v: Int) {
            val ru = getRoot(u)
            val rv = getRoot(v)
            if (ru == rv) {
                return
            }

            count--

            group[ru] = rv
        }

        for (i in 0..<n) {
            for (j in i+1..<n) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j)
                }
            }
        }

        return n - count
    }
}
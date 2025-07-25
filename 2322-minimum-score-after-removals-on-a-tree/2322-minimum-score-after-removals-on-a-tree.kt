class Solution {
    fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {
        val n = nums.size
        val d = IntArray(n)
        val f = IntArray(n)
        val sums = IntArray(n)

        val graph = Array(n) { mutableSetOf<Int>() }
        for ((a, b) in edges) {
            graph[a] += b
            graph[b] += a
        }

        var t = 0
        fun dfs(u: Int, p: Int) {
            d[u] = t++
            sums[u] = nums[u]
            for (v in graph[u]) {
                if (v == p) continue
                dfs(v, u)
                sums[u] = sums[v] xor sums[u]
            }
            f[u] = t++
        }

        dfs(0, -1)

        var answer = Int.MAX_VALUE
        for (i in 1..<n) {
            for (j in i+1..<n) {
                val (a, b, c) = when {
                    d[i] < d[j] && f[j] < f[i] -> {
                        Triple(sums[0] xor sums[i], sums[i] xor sums[j], sums[j])
                    }

                    d[j] < d[i] && f[i] < f[j] -> {
                        Triple(sums[0] xor sums[j], sums[i] xor sums[j], sums[i])
                    }

                    else -> {
                        Triple(sums[0] xor sums[i] xor sums[j], sums[i], sums[j])
                    }
                }

                answer = minOf(
                    answer,
                    maxOf(a, b, c) - minOf(a, b, c),
                )
            }
        }

        return answer
    }
}
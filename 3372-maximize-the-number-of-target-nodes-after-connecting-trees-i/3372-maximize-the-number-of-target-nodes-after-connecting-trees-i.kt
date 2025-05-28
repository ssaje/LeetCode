class Solution {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
        val n = edges1.size + 1
        val m = edges2.size + 1
        val g1 = Array(n) { IntArray(n) { n } }
        val g2 = Array(m) { IntArray(m) { m } }
        for ((a, b) in edges1) {
            g1[a][b] = 1
            g1[b][a] = 1
        }

        for (i in 0..<n) {
            g1[i][i] = 0
        }

        for ((u, v) in edges2) {
            g2[u][v] = 1
            g2[v][u] = 1
        }

        for (i in 0..<m) {
            g2[i][i] = 0
        }

        fw(n, g1)
        fw(m, g2)

        var max = 0
        for (i in 0..<m) {
            var sum = 0
            for (j in 0..<m) {
                if (g2[i][j] < k) {
                    sum++
                }
            }

            max = maxOf(max, sum)
        }

        val answer = IntArray(n) { max }
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (g1[i][j] <= k) {
                    answer[i]++
                }
            }
        }

        return answer
    }

    private fun fw(n: Int, g: Array<IntArray>) {
        for (k in 0..<n) {
            for (i in 0..<n) {
                for (j in 0..<n) {
                    if (g[i][k] != n && g[k][j] != n) {
                        g[i][j] = minOf(g[i][k] + g[k][j], g[i][j])
                    }
                }
            }
        }
    }
}
class Solution {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val n = colors.length
        val degs = IntArray(n)
        val graph = Array(n) { mutableSetOf<Int>() }
        val inv = Array(n) { mutableSetOf<Int>() }
        for ((a, b) in edges) {
            degs[b]++
            graph[a] += b
            inv[b] += a
        }

        val queue = ArrayDeque<Int>()
        for (i in degs.indices) {
            if (degs[i] == 0) {
                queue.addLast(i)
            }
        }

        var answer = 1
        val dp = Array(n) { IntArray(26) }
        repeat(n) {
            if (queue.isEmpty()) return -1

            val u = queue.removeFirst()
            for (v in inv[u]) {
                for (j in 0..<26) {
                    dp[u][j] = maxOf(dp[u][j], dp[v][j])
                    answer = maxOf(answer, dp[u][j])
                }
            }
            dp[u][colors[u] - 'a']++
            answer = maxOf(answer, dp[u][colors[u] - 'a'])

            for (v in graph[u]) {
                if (--degs[v] == 0) {
                    queue.addLast(v)
                }
            }
        }

        return answer
    }
}
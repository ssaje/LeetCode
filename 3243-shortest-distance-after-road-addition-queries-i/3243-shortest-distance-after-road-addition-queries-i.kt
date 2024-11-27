class Solution {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val graph = buildGraph(n)
        val dp = IntArray(n) { it }

        return IntArray(queries.size) { queryIndex ->
            val (from, to) = queries[queryIndex]
            query(graph, dp, from, to)
        }
    }

    private fun buildGraph(size: Int): Array<MutableList<Int>> {
        val graph = Array(size) { mutableListOf<Int>() }
        for (i in 1 until size) {
            graph[i - 1].add(i)
        }
        return graph
    }

    private fun query(
        graph: Array<MutableList<Int>>,
        dp: IntArray,
        from: Int,
        to: Int,
    ): Int {
        graph[from].add(to)

        val queue = ArrayDeque<Int>()

        var nextPathSize = dp[from] + 1
        queue.addLast(from)

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val node = queue.removeFirst()

                graph[node].forEach { nextNode ->
                    if (dp[nextNode] > nextPathSize) {
                        dp[nextNode] = nextPathSize
                        queue.add(nextNode)
                    }
                }
            }
            nextPathSize++
        }

        return dp.last()
    }
}
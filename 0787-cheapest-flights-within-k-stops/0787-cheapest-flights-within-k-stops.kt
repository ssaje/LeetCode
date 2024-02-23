class Solution {
    companion object {
        private const val MAX = 987654321
    }

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val distances = Array(k + 2) { IntArray(n) { MAX } }
        distances[0][src] = 0

        val G = Array(n) { mutableMapOf<Int, Int>() }
        for ((from, to, price) in flights) {
            G[from][to] = price
        }

        repeat(k + 1) {
            for (u in 0 until n) {
                val distance = distances[it][u]
                if (distance == MAX) {
                    continue
                }

                for ((v, price) in G[u]) {
                    distances[it + 1][v] = distances[it + 1][v].coerceAtMost(distance + price)
                }
            }
        }

        var answer = MAX
        for (i in 1..k+1) {
            answer = answer.coerceAtMost(distances[i][dst])
        }

        return if (answer == MAX) -1 else answer
    }
}
class Solution {
    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        val costs = Array(26) { i -> IntArray(26) { j -> if (i == j) 0 else MAX } }
        for (k in 0..<original.size) {
            val i = original[k] - 'a'
            val j = changed[k] - 'a'
            costs[i][j] = minOf(costs[i][j], cost[k])
        }

        for (k in 0..<26) {
            for (i in 0..<26) {
                for (j in 0..<26) {
                    costs[i][j] = minOf(costs[i][j], costs[i][k] + costs[k][j])
                }
            }
        }

        var answer = 0L
        for (k in 0..<source.length) {
            val i = source[k] - 'a'
            val j = target[k] - 'a'
            if (costs[i][j] == MAX) return -1

            answer += costs[i][j]
        }

        return answer
    }

    companion object {
        private const val MAX = 1_000_000 * 26
    }
}
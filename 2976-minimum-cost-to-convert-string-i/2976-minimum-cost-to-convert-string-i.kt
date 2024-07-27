class Solution {
    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        val costs = Array(26) { IntArray(26) { 987654321 } }
        for (i in 0..<26) {
            costs[i][i] = 0
        }
        
        original.forEachIndexed { index, o ->
            val c = changed[index]
            if (costs[o - 'a'][c - 'a'] > cost[index]) {
                costs[o - 'a'][c - 'a'] = cost[index]
            }
        }

        for (k in 0..<26) {
            for (i in 0..<26) {
                for (j in 0..<26) {
                    costs[i][j] = costs[i][j].coerceAtMost(costs[i][k] + costs[k][j])
                }
            }
        }

        var answer = 0L
        for (i in 0..source.lastIndex) {
            val s = source[i]
            val t = target[i]
            if (costs[s - 'a'][t - 'a'] == 987654321) {
                return -1
            }

            answer += costs[s - 'a'][t - 'a']
        }

        return answer
    }
}
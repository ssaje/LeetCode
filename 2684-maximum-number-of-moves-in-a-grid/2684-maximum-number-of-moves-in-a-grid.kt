class Solution {
    fun maxMoves(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val states = Array(2) { IntArray(m) }
        var answer = 0

        for (j in 1..<n) {
            for (i in 0..<m) {
                states[1][i] = -1

                if (grid[i][j] > grid[i][j - 1] && states[0][i] != -1) {
                    states[1][i] = states[1][i].coerceAtLeast(states[0][i] + 1)
                }
                
                if (i > 0 && grid[i][j] > grid[i - 1][j - 1] && states[0][i - 1] != -1) {
                    states[1][i] = states[1][i].coerceAtLeast(states[0][i - 1] + 1)
                }

                if (i + 1 < m && grid[i][j] > grid[i + 1][j - 1] && states[0][i + 1] != -1) {
                    states[1][i] = states[1][i].coerceAtLeast(states[0][i + 1] + 1)
                }
            }

            var canReach = false

            for (i in 0..<m) {
                states[0][i] = states[1][i]
                
                if (states[1][i] != -1) {
                    canReach = true
                    answer = answer.coerceAtLeast(states[0][i])
                }
            }

            if (!canReach) {
                break
            }
        }

        return answer
    }
}
class Solution {
    fun largestIsland(grid: Array<IntArray>): Int {
        val n = grid.size
        val range = 0..<n
        val groups = Array(n) { IntArray(n) }
        val groupSizes = mutableMapOf<Int, Int>()
        var groupCount = 0

        fun dfs(i: Int, j: Int): Int {
            groups[i][j] = groupCount

            var sum = 1
            for ((di, dj) in dirs) {
                val ni = di + i
                val nj = dj + j
                if (ni !in range || nj !in range) {
                    continue
                }

                if (grid[ni][nj] == 1 && groups[ni][nj] == 0) {
                    sum += dfs(ni, nj)
                }
            }

            return sum
        }

        var answer = 0
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (grid[i][j] == 1 && groups[i][j] == 0) {
                    groupCount++
                    
                    val groupSize = dfs(i, j)
                    groupSizes[groupCount] = groupSize
                    answer = answer.coerceAtLeast(groupSize)
                }
            }
        }

        if (answer == n * n) {
            return answer
        }

        for (i in 0..<n) {
            for (j in 0..<n) {
                if (grid[i][j] == 1) {
                    continue
                }

                val adjSum = dirs.mapNotNull { (di, dj) ->
                    val ni = i + di
                    val nj = j + dj
                    if (ni !in range || nj !in range || grid[ni][nj] == 0) {
                        null
                    } else {
                        groups[ni][nj]
                    }
                }.distinct().sumOf { groupSizes[it]!! }

                answer = answer.coerceAtLeast(adjSum)
            }
        }

        return answer + 1
    }

    companion object {
        private val dirs = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    }
}
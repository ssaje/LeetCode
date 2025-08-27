class Solution {
    fun lenOfVDiagonal(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val dp = Array(n) { Array(m) { Array(4) { IntArray(2) { -1 } } } }

        fun dfs(i: Int, j: Int, dir: Int, turn: Int, term: Int): Int {
            val (di, dj) = dirs[dir]
            val ni = di + i
            val nj = dj + j
            if (ni !in 0..<n || nj !in 0..<m || grid[ni][nj] != term) return 0
            
            if (dp[ni][nj][dir][turn] != -1) return dp[ni][nj][dir][turn]

            var ret = dfs(ni, nj, dir, turn, 2 - term)
            if (turn == 0) {
                ret = maxOf(
                    ret,
                    dfs(ni, nj, (dir + 1) % 4, turn + 1, 2 - term)
                )
            }

            dp[ni][nj][dir][turn] = ret + 1
            return ret + 1
        }

        var answer = 0
        for (i in 0..<n) {
            for (j in 0..<m) {
                for (dir in 0..<4) {
                    if (grid[i][j] == 1) {
                        answer = maxOf(
                            answer,
                            dfs(i, j, dir, 0, 2) + 1,
                        )
                    }
                }
            }
        }

        return answer
    }

    companion object {
        private val dirs = listOf(
            1 to 1,
            1 to -1,
            -1 to -1,
            -1 to 1,
        )
    }
}
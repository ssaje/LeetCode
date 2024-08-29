class Solution {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        val m = grid1.size
        val n = grid1[0].size
        val visited = Array(m) { BooleanArray(n) }

        fun dfs(i: Int, j: Int): Int {
            if (visited[i][j] == true) {
                return 1   
            }

            visited[i][j] = true

            var ret = 1
            if (grid1[i][j] == 0) {
                ret = 0
            }

            if (i > 0 && grid2[i - 1][j] == 1) {
                ret = ret.coerceAtMost(dfs(i - 1, j))
            }

            if (j > 0 && grid2[i][j - 1] == 1) {
                ret = ret.coerceAtMost(dfs(i, j - 1))
            }

            if (i + 1 < m && grid2[i + 1][j] == 1) {
                ret = ret.coerceAtMost(dfs(i + 1, j))
            }

            if (j + 1 < n && grid2[i][j + 1] == 1) {
                ret = ret.coerceAtMost(dfs(i, j + 1))
            }

            return ret
        }

        var answer = 0
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid2[i][j] == 1 && visited[i][j] == false) {
                    answer += dfs(i, j)
                }
            }
        }

        return answer
    }
}
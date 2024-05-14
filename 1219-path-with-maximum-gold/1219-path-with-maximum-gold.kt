class Solution {
    fun getMaximumGold(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) }
        var answer = 0

        fun dfs(r: Int, c: Int, sum: Int = 0) {
            if (grid[r][c] == 0) {
                return
            }

            val nextSum = sum + grid[r][c]
            if (answer < nextSum) {
                answer = nextSum
            }

            visited[r][c] = true

            if (r > 0 && !visited[r - 1][c]) { dfs(r - 1, c, nextSum) }
            if (c > 0 && !visited[r][c - 1]) { dfs(r, c - 1, nextSum) }
            if (r + 1 < m && !visited[r + 1][c]) { dfs(r + 1, c, nextSum) }
            if (c + 1 < n && !visited[r][c + 1]) { dfs(r, c + 1, nextSum) }

            visited[r][c] = false
        }

        for (i in 0..<m) {
            for (j in 0..<n) {
                dfs(i, j)
            }
        }

        return answer
    }
}
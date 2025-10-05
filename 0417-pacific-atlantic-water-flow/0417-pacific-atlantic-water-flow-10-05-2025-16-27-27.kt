class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val m = heights.size
        val n = heights[0].size
        val visited = Array(m) { IntArray(n) }

        fun dfs(i: Int, j: Int, target: Int) {
            visited[i][j] = visited[i][j] or target
            
            for ((di, dj) in dirs) {
                val ni = i + di
                val nj = j + dj
                if (ni !in 0..<m || nj !in 0..<n) continue
                if (visited[ni][nj] and target != 0) continue
                if (heights[ni][nj] >= heights[i][j]) dfs(ni, nj, target)
            }
        }

        for (i in 0..<m) {
            if (visited[i][0] and 1 == 0) dfs(i, 0, 1)
            if (visited[i][n - 1] and 2 == 0) dfs(i, n - 1, 2)
        }

        for (j in 0..<n) {
            if (visited[0][j] and 1 == 0) dfs(0, j, 1)
            if (visited[m - 1][j] and 2 == 0) dfs(m - 1, j, 2)
        }

        return buildList {
            for (i in 0..<m) { 
                for (j in 0..<n) {
                    if (visited[i][j] == 3) {
                        add(listOf(i, j))
                    }
                }
            }
        }
    }

    companion object {
        private val dirs = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    }
}
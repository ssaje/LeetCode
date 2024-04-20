class Solution {
    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val m = land.size
        val n = land[0].size
        val answers = mutableListOf<IntArray>()
        val visited = Array(m) { BooleanArray(n) }

        fun dfs(i: Int, j: Int, group: Int) {
            if (visited[i][j] || land[i][j] == 0) {
                return
            }

            visited[i][j] = true

            if (answers[group][0] > i) {
                answers[group][0] = i
            }

            if (answers[group][1] > j) {
                answers[group][1] = j
            }

            if (answers[group][2] < i) {
                answers[group][2] = i
            }

            if (answers[group][3] < j) {
                answers[group][3] = j
            }

            if (i > 0) {
                dfs(i - 1, j, group)
            }

            if (j > 0) {
                dfs(i, j - 1, group)
            }

            if (i + 1 < m) {
                dfs(i + 1, j, group)
            }

            if (j + 1 < n) {
                dfs(i, j + 1, group)
            }
        }

        for (i in land.indices) {
            for (j in land[i].indices) {
                if (!visited[i][j] && land[i][j] == 1) {
                    answers += intArrayOf(300, 300, 0, 0)
                    dfs(i, j, answers.lastIndex)
                }
            }
        }

        return answers.toTypedArray()
    }
}
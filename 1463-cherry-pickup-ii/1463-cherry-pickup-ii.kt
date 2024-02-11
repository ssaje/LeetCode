class Solution {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val col = grid[0].size
        var prev = Array(col) { IntArray(col) { -1 } }.apply {
            this[0][col - 1] = grid[0][0] + grid[0][col - 1]
        }

        for (row in 1..grid.lastIndex) {
            val curr = Array(col) { IntArray(col) { -1 } }

            for (i in 0..<col) {
                for (j in 0..<col) {
                    var max = -1
                    for (a in i-1..i+1) {
                        for (b in j-1..j+1) {
                            val state = prev
                                .getOrNull(a)
                                ?.getOrNull(b)
                                ?: continue
                            if (max < state) {
                                max = state
                            }
                        }
                    }

                    if (max == -1) {
                        continue
                    }

                    max += grid[row][i]
                    if (i != j) {
                        max += grid[row][j]
                    }

                    if (curr[i][j] < max) {
                        curr[i][j] = max
                    }
                }
            }

            prev = curr
        }

        return prev.maxOf { it.maxOrNull()!! }
    }
}
class Solution {
    companion object {
        private const val MOD = 1_000_000_000 + 7
        private val dirs = listOf(
            -1 to 0,
            0 to 1,
            1 to 0,
            0 to -1,
        )
    }

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        var answer = 0
        val d = Array(maxMove + 1) { Array(m) { IntArray(n) } }
        d[0][startRow][startColumn] = 1

        val iRange = 0 until m
        val jRange = 0 until n

        for (currentMove in 0 until maxMove) {
            for (i in iRange) {
                for (j in jRange) {
                    for ((di, dj) in dirs) {
                        val x = i + di
                        val y = j + dj

                        if (x !in iRange || y !in jRange) {
                            answer = (answer + d[currentMove][i][j]) % MOD
                            continue
                        } else {
                            d[currentMove + 1][x][y] = (d[currentMove + 1][x][y] + d[currentMove][i][j]) % MOD
                        }
                    }
                }
            }
        }

        return answer
    }
}
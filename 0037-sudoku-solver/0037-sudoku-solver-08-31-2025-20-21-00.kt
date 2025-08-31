class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        val rows = Array(9) { mutableSetOf<Char>('1','2','3','4','5','6','7','8','9') }
        val cols = Array(9) { mutableSetOf<Char>('1','2','3','4','5','6','7','8','9') }
        val subs = Array(9) { mutableSetOf<Char>('1','2','3','4','5','6','7','8','9') }

        for (i in 0..<9) {
            for (j in 0..<9) {
                val number = board[i][j]
                rows[i] -= number
                cols[j] -= number
                subs[sub(i, j)] -= number
            }
        }

        fun solve(i: Int, j: Int): Boolean {
            if (j == 9) {
                return if (i == 8) true else solve(i + 1, 0)
            }
            
            if (board[i][j] != '.') return solve(i, j + 1)

            for (k in '1'..'9') {
                val index = sub(i, j)
                if (k in rows[i] && k in cols[j] && k in subs[index]) {
                    board[i][j] = k
                    rows[i] -= k
                    cols[j] -= k
                    subs[index] -= k
                    if (solve(i, j + 1)) return true
                    board[i][j] = '.'
                    rows[i] += k
                    cols[j] += k
                    subs[index] += k
                }
            }

            return false
        }

        solve(0, 0)
    }

    private fun sub(i: Int, j: Int): Int {
        return (i / 3) * 3 + (j / 3)
    }
}
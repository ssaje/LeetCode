class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in 0..<9) {
            val counts = IntArray(10)
            for (j in 0..<9) {
                val ch = board[i][j]
                if (ch == '.') continue
                if (++counts[ch - '0'] > 1) {
                    return false
                }
            }

            val counts2 = IntArray(10)
            for (j in 0..<9) {
                val ch = board[j][i]
                if (ch == '.') continue
                if (++counts2[ch - '0'] > 1) {
                    return false
                }
            }

            val x = (i / 3) * 3
            val y = (i % 3) * 3
            val counts3 = IntArray(10)            
            for (di in 0..<3) {
                for (dj in 0..<3) {
                    val ch = board[x + di][y + dj]
                    if (ch == '.') continue
                    if (++counts3[ch - '0'] > 1) {
                        return false
                    }
                }
            }
        }

        return true
    }
}
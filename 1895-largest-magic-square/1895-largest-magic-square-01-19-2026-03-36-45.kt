class Solution {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        fun isMagicSquare(si: Int, sj: Int, k: Int): Boolean {
            val rows = IntArray(k)
            val cols = IntArray(k)
            var diag = 0
            var rdiag = 0

            for (i in 0..<k) {
                for (j in 0..<k) {
                    val cell = grid[si + i][sj + j]
                    
                    rows[i] += cell
                    cols[j] += cell

                    if (i == j) {
                        diag += cell
                    }

                    if (i + j == k - 1) {
                        rdiag += cell
                    }
                }
            }

            if (diag != rdiag) return false
            for (i in 0..<k) {
                if (diag != rows[i]) return false
                if (diag != cols[i]) return false
            }

            return true
        }

        val m = grid.size
        val n = grid[0].size
        var k = minOf(m, n)
        while (k > 1) {
            for (i in 0..m-k) {
                for (j in 0..n-k) {
                    if (isMagicSquare(i, j, k)) return k
                }
            }

            k--
        }

        return 1
    }
}
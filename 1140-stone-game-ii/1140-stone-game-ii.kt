class Solution {
    fun stoneGameII(piles: IntArray): Int {
        val n = piles.size
        val d = Array(n + 1) { IntArray(n + 1) }
        val sums = IntArray(n + 1)

        for (i in n - 1 downTo 0) {
            sums[i] = sums[i + 1] + piles[i]
        }
        
        for (i in 0..n) {
            d[i][n] = sums[i]
        }

        for (i in n - 1 downTo 0) {
            for (j in n - 1 downTo 1) {
                var x = 1
                while (x <= 2 * j && i + x <= n) {
                    d[i][j] = d[i][j].coerceAtLeast(sums[i] - d[i + x][max(x, j)])
                    x++
                }
            }
        }

        return d[0][1]
    }
}
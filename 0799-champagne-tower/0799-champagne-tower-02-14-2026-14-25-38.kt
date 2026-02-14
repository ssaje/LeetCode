class Solution {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val towers = Array(query_row + 1) { DoubleArray(query_glass + 1) }
        towers[0][0] = poured.toDouble()

        for (i in 1..query_row) {
            if (towers[i - 1][0] > 1.0) {
                towers[i][0] = (towers[i - 1][0] - 1.0) / 2.0
            }

            for (j in 1..query_glass) {
                if (towers[i - 1][j - 1] > 1.0) {
                    towers[i][j] += (towers[i - 1][j - 1] - 1.0) / 2.0
                }

                if (towers[i - 1][j] > 1.0) {
                    towers[i][j] += (towers[i - 1][j] - 1.0) / 2.0
                }
            }
        }

        return minOf(towers[query_row][query_glass], 1.0)
    }
}
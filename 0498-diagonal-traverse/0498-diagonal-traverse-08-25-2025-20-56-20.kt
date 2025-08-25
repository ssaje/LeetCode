class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        return mat
            .flatMapIndexed { i, row ->
                row.mapIndexed { j, el ->
                    intArrayOf(i, j, el)
                }
            }
            .sortedWith(
                compareBy(
                    { it[0] + it[1] },
                    {
                        if ((it[0] + it[1]) % 2 == 0) it[1]
                        else it[0]
                    },
                )
            )
            .map { it[2] }
            .toIntArray()
    }
}
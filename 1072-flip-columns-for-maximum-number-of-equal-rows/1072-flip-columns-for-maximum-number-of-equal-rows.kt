class Solution {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val counts = mutableMapOf<String, Int>()
        var answer = 0
        for (row in matrix.indices) {
            val original = buildString {
                for (cell in matrix[row]) {
                    append(cell.toString())    
                }
            }

            counts[original] = (counts[original] ?: 0) + 1
            answer = answer.coerceAtLeast(counts[original]!!)

            val reversed = buildString {
                for (cell in matrix[row]) {
                    append((1 - cell).toString())
                }
            }

            counts[reversed] = (counts[reversed] ?: 0) + 1
            answer = answer.coerceAtLeast(counts[reversed]!!)
        }

        return answer
    }
}
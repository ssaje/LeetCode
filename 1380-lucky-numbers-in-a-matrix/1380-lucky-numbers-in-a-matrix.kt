class Solution {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val maxes = IntArray(matrix[0].size) { j ->
            var index = 0
            for (i in 0..matrix.lastIndex) {
                if (matrix[i][j] > matrix[index][j]) {
                    index = i
                }
            }

            index
        }

        return buildList {
            for (i in 0..matrix.lastIndex) {
                var index = 0
                for (j in 0..matrix[i].lastIndex) {
                    if (matrix[i][j] < matrix[i][index]) {
                        index = j
                    }
                }

                if (maxes[index] == i) {
                    add(matrix[i][index])
                }
            }
        }
    }
}
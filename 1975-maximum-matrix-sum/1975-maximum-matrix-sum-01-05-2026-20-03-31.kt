class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var answer = 0L
        var min = Int.MAX_VALUE
        var count = 0
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                answer += matrix[i][j].absoluteValue
                min = min.coerceAtMost(matrix[i][j].absoluteValue)
                
                if (matrix[i][j] < 0) {
                    count++
                }
            }
        }

        if (count % 2 == 0) {
            return answer
        }

        return answer - min * 2
    }
}
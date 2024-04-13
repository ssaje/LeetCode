class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        var answer = 0
        val h = IntArray(matrix[0].size)
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == '0') {
                    h[j] = 0
                } else {
                    h[j]++
                }
            }

            for (j in h.indices) {
                var minHeight = 201
                for (k in j downTo 0) {
                    if (minHeight > h[k]) {
                        minHeight = h[k]
                    }

                    val area = minHeight * (j - k + 1)
                    if (answer < area){
                        answer = area
                    }
                }
            }
        }

        return answer
    }
}
class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        return Array(matrix[0].size) { i ->
            IntArray(matrix.size) { j ->
                matrix[j][i]
            }
        }
    }
}
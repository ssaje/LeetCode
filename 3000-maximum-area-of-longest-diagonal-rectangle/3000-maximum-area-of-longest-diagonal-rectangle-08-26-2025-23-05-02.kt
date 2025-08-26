class Solution {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var answer = 0
        var diag = 0
        var area = 0
        for ((length, width) in dimensions) {
            val area = length * width
            val sqSum = length*length + width*width
            if (diag < sqSum) {
                answer = area
                diag = sqSum
            } else if (diag == sqSum && answer < area) {
                answer = area
            }
        }

        return answer
    }
}
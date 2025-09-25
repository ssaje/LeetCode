class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        var current = IntArray(n)
        current[0] = triangle[0][0]
        for (i in 1..<n) {
            val next = IntArray(n)
            next[0] = current[0] + triangle[i][0]
            for (j in 1..<i) {
                next[j] = minOf(current[j - 1], current[j]) + triangle[i][j]
            }
            next[i] = current[i - 1] + triangle[i][i]

            current = next
        }

        return current.min()
    }
}
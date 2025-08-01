class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val c = mutableListOf<List<Int>>(listOf(1))
        for (i in 1..<numRows) {
            val current = mutableListOf<Int>(1)
            for (j in 1..<i) {
                current += c[i - 1][j - 1] + c[i - 1][j]
            }
            current += 1

            c += current
        }

        return c
    }
}
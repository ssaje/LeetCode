class Solution {
    fun hasSameDigits(s: String): Boolean {
        val n = s.length
        var current = s.map { it.digitToInt() }.toIntArray()
        repeat(n - 2) {
            val next = IntArray(n)
            for (i in it+1..<n) {
                next[i] = (current[i] + current[i - 1]) % 10
            }

            current = next
        }

        return current[n - 1] == current[n - 2]
    }
}
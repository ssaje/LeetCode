class Solution {
    fun findTheLongestSubstring(s: String): Int {
        val previous = mutableMapOf<Int, Int>(
            0 to -1
        )

        var answer = 0
        var acc = 0
        for (i in s.indices) {
            val ch = s[i]
            if (ch in setOf('a', 'e', 'i', 'o', 'u')) {
                acc = acc xor (1 shl (ch - 'a'))
            }

            if (acc !in previous) {
                previous += acc to i
            }

            answer = answer.coerceAtLeast(i - previous[acc]!!)
        }

        return answer
    }
}
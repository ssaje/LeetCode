class Solution {
    fun reverseString(s: CharArray): Unit {
        val halfSize = s.size / 2

        (0..<halfSize).forEach { index ->
            s[index] = s[s.lastIndex - index].also {
                s[s.lastIndex - index] = s[index]
            }
        }
    }
}
class Solution {
    fun minimumLength(s: String): Int {
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            if (s[i] != s[j]) {
                break
            }

            val ch = s[i]
            while (i < j && s[i] == ch) {
                i++
            }

            while (i <= j && s[j] == ch) {
                j--
            }
        }

        return j - i + 1
    }
}
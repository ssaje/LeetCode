class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var i = 0
        for (ch in s) {
            if (ch == t[i]) {
                i++
                if (i == t.length) {
                    break
                }
            }
        }

        return t.length - i
    }
}
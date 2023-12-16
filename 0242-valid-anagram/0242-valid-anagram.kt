class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val count = IntArray(26)
        for (ch in s) {
            ++count[ch.code - 97]
        }

        for (ch in t) {
            if (--count[ch.code - 97] < 0) {
                return false
            }
        }

        return true
    }
}
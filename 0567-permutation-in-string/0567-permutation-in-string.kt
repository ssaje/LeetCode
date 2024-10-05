class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val pattern = IntArray(26)
        val counts = IntArray(26)

        for (ch in s1) {
            pattern[ch - 'a']++
        }

        fun includes(): Boolean {
            for (i in 0..<26) {
                if (pattern[i] != counts[i]) {
                    return false
                }
            }

            return true
        }

        for (i in s2.indices) {
            counts[s2[i] - 'a']++

            if (i >= s1.lastIndex) {
                if (includes()) {
                    return true
                }

                counts[s2[i - s1.lastIndex] - 'a']--
            }
        }

        return false
    }
}
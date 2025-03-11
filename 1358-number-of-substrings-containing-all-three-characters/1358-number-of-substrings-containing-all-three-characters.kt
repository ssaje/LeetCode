class Solution {
    fun numberOfSubstrings(s: String): Int {
        var answer = 0
        val counts = mutableMapOf<Char, Int>()
        var l = 0
        for (r in s.indices) {
            val rc = s[r]
            counts[rc] = (counts[rc] ?: 0) + 1

            while (counts.size == 3) {
                answer += s.length - r

                val lc = s[l++]
                counts[lc] = counts[lc]!! - 1
                if (counts[lc] == 0) {
                    counts.remove(lc)
                }
            }
        }

        return answer
    }
}
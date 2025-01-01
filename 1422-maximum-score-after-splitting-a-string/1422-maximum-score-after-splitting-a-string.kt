class Solution {
    fun maxScore(s: String): Int {
        var zeros = 0
        var ones = s.count { it == '1' }
        var answer = 0
        for (i in 0..<s.lastIndex) {
            val ch = s[i]
            if (ch == '0') {
                zeros++
            } else {
                ones--
            }

            answer = answer.coerceAtLeast(zeros + ones)
        }

        return answer
    }
}
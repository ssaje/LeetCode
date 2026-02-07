class Solution {
    fun minimumDeletions(s: String): Int {
        var b = 0
        var answer = 0
        for (i in 1..s.length) {
            val ch = s[i - 1]
            if (ch == 'a') {
                answer = min(answer + 1, b)
            } else {
                b++                
            }
        }

        return answer
    }
}
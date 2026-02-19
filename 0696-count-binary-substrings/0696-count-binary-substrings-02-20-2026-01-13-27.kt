class Solution {
    fun countBinarySubstrings(s: String): Int {
        var a = 0
        var b = 1
        var answer = 0
        for (i in 1..<s.length) {
            if (s[i - 1] != s[i]) {
                answer += minOf(a, b)
                a = b
                b = 1
            } else {
                b++
            }
        }

        return answer + minOf(a, b)
    }
}
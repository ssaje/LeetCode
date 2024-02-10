class Solution {
    fun countSubstrings(s: String): Int {
        val p = Array(s.length) { IntArray(s.length) { -1 } }
        
        fun isPalindrome(start: Int, end: Int): Boolean {
            if (start >= end) {
                return true
            }
            
            if (p[start][end] != -1) {
                return p[start][end] == 1
            }

            p[start][end] = if (s[start] == s[end] && isPalindrome(start + 1, end - 1)) 1 else 0

            return p[start][end] == 1
        }

        var answer = 0
        for (i in s.indices) {
            for (j in i..s.lastIndex) {
                if (isPalindrome(i, j)) {
                    answer++
                }
            }
        }

        return answer
    }
}
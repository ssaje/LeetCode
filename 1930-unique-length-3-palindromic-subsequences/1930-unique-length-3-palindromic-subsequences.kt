class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val starts = IntArray(26) { -1 }
        val ends = IntArray(26)

        for (i in s.indices) {
            val pos = s[i] - 'a'
            if (starts[pos] == -1) {
                starts[pos] = i
            }

            ends[pos] = i
        }

        var answer = 0
        for (i in 0..<26) {
            val start = starts[i]
            if (start == -1) {
                continue
            }

            val end = ends[i]
            if (start + 1 > end - 1) {
                continue
            }

            answer += s.slice(start+1..end-1).toSet().size
        }

        return answer
    }
}
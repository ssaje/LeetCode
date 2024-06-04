class Solution {
    fun longestPalindrome(s: String): Int {
        val counts = HashMap<Char, Int>()
        var answer = 0
        for (ch in s) {
            counts[ch] = (counts[ch] ?: 0) + 1
            if (counts[ch]!! % 2 == 0) {
                answer += 2
            }
        }

        if (answer != s.length) {
            ++answer
        }

        return answer
    }
}
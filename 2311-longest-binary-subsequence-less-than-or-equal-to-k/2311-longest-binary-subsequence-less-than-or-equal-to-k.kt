class Solution {
    fun longestSubsequence(s: String, k: Int): Int {
        val length = k.toString(2).length
        var sum = 0
        var answer = 0
        for (i in s.indices) {
            val right = s[s.length - 1 - i]
            if (right == '0') {
                answer++
            } else if (i < length && sum + (1 shl i) <= k) {
                sum += 1 shl i
                answer++
            }
        }

        return answer
    }
}
class Solution {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var answer = 0
        var sum = 0
        var prev = 0
        for (i in s.indices) {
            sum += (s[i] - t[i]).absoluteValue
            while (sum > maxCost && prev <= i) {
                sum -= (s[prev] - t[prev]).absoluteValue
                prev++
            }

            answer = answer.coerceAtLeast(i - prev + 1)
        }
        
        return answer
    }
}
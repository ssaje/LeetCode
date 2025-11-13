class Solution {
    fun maxOperations(s: String): Int {
        val n = s.length
        var count = 0
        var j = n
        var answer = 0
        for (i in 0..<n) {
            if (s[i] == '0') continue
            else if (i > 0 && s[i - 1] == '0') answer += count

            count++
        }

        if (s[n - 1] == '0') answer += count

        return answer
    }
}
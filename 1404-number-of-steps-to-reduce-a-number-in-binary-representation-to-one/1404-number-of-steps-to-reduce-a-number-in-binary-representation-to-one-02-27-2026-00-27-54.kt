class Solution {
    fun numSteps(s: String): Int {
        var current = 0
        var answer = 0
        for (i in s.length - 1 downTo 1) {
            if (s[i] == '1') current++
            
            if (current % 2 == 1) {
                current++
                answer += 2
            } else {
                answer++
            }
            
            current /= 2
        }

        return answer + current
    }
}
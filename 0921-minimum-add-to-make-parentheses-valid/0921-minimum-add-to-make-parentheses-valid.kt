class Solution {
    fun minAddToMakeValid(s: String): Int {
        var answer = 0
        var count = 0

        for (ch in s) {
            if (ch == '(') {
                count++
            } else if (count == 0) {
                answer++
            } else {
                count--
            }
        }

        return answer + count
    }
}
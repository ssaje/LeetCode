class Solution {
    fun maxDepth(s: String): Int {
        var count = 0
        var answer = 0
        for (ch in s) {
            if (ch == '(') {
                count++
                if (answer < count) {
                    answer = count
                }
            } else if (ch == ')') {
                count--
            }
        }

        return answer
    }
}
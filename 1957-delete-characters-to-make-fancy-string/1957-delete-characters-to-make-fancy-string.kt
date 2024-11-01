class Solution {
    fun makeFancyString(s: String): String {
        val answer = StringBuilder()
        var lastCh = ' '
        var sum = 0
        for (ch in s) {
            if (ch == lastCh) {
                sum++
            } else {
                sum = 1
                lastCh = ch
            }

            if (sum < 3) {
                answer.append(ch)
            }
        }

        return answer.toString()
    }
}
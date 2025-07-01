class Solution {
    fun possibleStringCount(word: String): Int {
        var last = ' '
        var answer = 1
        for (ch in word) {
            if (last != ch) {
                last = ch
            } else {
                answer++
            }
        }

        return answer
    }
}
class Solution {
    fun minChanges(s: String): Int {
        var answer = 0
        var i = 0

        while (i < s.length) {
            val currentCh = s[i]
            var count = 0
            while (
                i < s.length &&
                currentCh == s[i]
            ) {
                count++
                i++
            }

            if (count % 2 == 1) {
                answer++
                i++
            }
        }

        return answer
    }
}
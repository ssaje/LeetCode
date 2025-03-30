class Solution {
    fun partitionLabels(s: String): List<Int> {
        val rights = IntArray(26)
        for (i in s.indices) {
            rights[s[i] - 'a'] = i
        }

        val answer = mutableListOf<Int>()
        var l = 0
        while (l < s.length) {
            var r = l
            var i = r
            while (i <= r) {
                r = maxOf(r, rights[s[i] - 'a'])
                i++
            }

            answer += i - l
            l = i
        }

        return answer
    }
}
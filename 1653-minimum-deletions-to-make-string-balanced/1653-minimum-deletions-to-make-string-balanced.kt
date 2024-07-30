class Solution {
    fun minimumDeletions(s: String): Int {
        var aSum = 0
        var aCont = 0
        val d = IntArray(s.length + 1)
        for (i in 1..s.length) {
            val ch = s[i - 1]
            if (ch == 'a') {
                aCont++
                aSum++

                d[i] = min(d[i - aCont] + aCont, i - aSum)
            } else {
                aCont = 0

                d[i] = min(d[i - 1], i - aSum)
            }
        }

        return d[s.length]
    }
}
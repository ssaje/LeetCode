class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') {
            return 0
        }

        val D = IntArray(s.length + 1)
        D[0] = 1
        D[1] = 1

        for (i in 2..s.length) {
            val ch = s[i - 1]
            if (ch != '0') {
                D[i] = D[i - 1]
            }

            val n = s[i - 2].digitToInt() * 10 + ch.digitToInt()
            if (n in 10..26) {
                D[i] += D[i - 2]
            }
        }

        return D[s.length]
    }
}
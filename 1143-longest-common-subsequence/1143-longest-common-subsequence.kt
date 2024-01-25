class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val d = Array(text1.length) { IntArray(text2.length) }
        d[0][0] = if (text1[0] == text2[0]) 1 else 0

        for (i in 1..text1.lastIndex) {
            d[i][0] = max(d[i - 1][0], if (text1[i] == text2[0]) 1 else 0)
        }

        for (j in 1..text2.lastIndex) {
            d[0][j] = max(d[0][j - 1], if (text1[0] == text2[j]) 1 else 0)
        }

        for (i in 1..text1.lastIndex) {
            for (j in 1..text2.lastIndex) {
                d[i][j] = max(d[i - 1][j], d[i][j - 1])
                if (text1[i] == text2[j] && d[i][j] < d[i - 1][j - 1] + 1) {
                    d[i][j] = d[i - 1][j - 1] + 1
                }
            }
        }

        return d[text1.lastIndex][text2.lastIndex]
    }
}
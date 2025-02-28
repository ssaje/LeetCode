class Solution {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val n = str1.length
        val m = str2.length
        val parents = Array(n) { mutableMapOf<Int, Pair<Int, Int>>() }
        val cached = Array(n) { IntArray(m) { -1 } }
        
        fun lcs(i: Int, j: Int): Int {
            if (i == n || j == m) {
                return 0
            } else if (cached[i][j] != -1) {
                return cached[i][j]
            }

            if (str1[i] == str2[j]) {
                parents[i][j] = i + 1 to j + 1
                cached[i][j] = lcs(i + 1, j + 1) + 1
            } else {
                val a = lcs(i + 1, j)
                val b = lcs(i, j + 1)
                if (a > b) {
                    parents[i][j] = i + 1 to j
                    cached[i][j] = a
                } else {
                    parents[i][j] = i to j + 1
                    cached[i][j] = b
                }
            }

            return cached[i][j]
        }

        lcs(0, 0)

        return buildString {
            var i = 0
            var j = 0
            while (i < n && j < m) {
                val (ni, nj) = parents[i][j]!!
                if (i + 1 == ni) {
                    append(str1[i])
                } else {
                    append(str2[j])
                }

                i = ni
                j = nj
            }

            while (i < n) {
                append(str1[i])
                i = i + 1
            }

            while (j < m) {
                append(str2[j])
                j = j + 1
            }
        }
    }
}
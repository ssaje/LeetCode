class Solution {
    fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        fun canUse(a: String, b: String): Boolean {
            if (a.length != b.length) return false

            var distance = 0
            for (i in a.indices) {
                if (a[i] != b[i]) {
                    distance++
                    if (distance > 1) {
                        return false
                    }
                }
            }

            return distance == 1
        }

        var k = 0
        var prev = IntArray(words.size) { -1 }
        val dp = IntArray(words.size)
        for (i in words.indices) {
            for (j in 0..<i) {
                if (groups[j] != groups[i] && canUse(words[j], words[i]) && dp[i] < dp[j]) {
                    dp[i] = dp[j]
                    prev[i] = j
                }
            }

            dp[i]++
            if (dp[k] < dp[i]) {
                k = i
            }
        }

        val answer = mutableListOf<String>()
        fun dfs(i: Int) {
            if (i == -1) {
                return
            }

            dfs(prev[i])
            answer += words[i]
        }

        dfs(k)

        return answer
    }
}
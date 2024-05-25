class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val answer = mutableListOf<String>()
        val split = mutableListOf<String>()

        fun solve(index: Int) {
            if (index == s.length) {
                answer += split.joinToString(" ")
                return
            }

            for (word in wordDict) {
                if (s.startsWith(word, index)) {
                    split += word
                    solve(index + word.length)
                    split.removeLast()
                }
            }
        }

        solve(0)

        return answer
    }
}
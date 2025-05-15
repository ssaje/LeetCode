class Solution {
    fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        var a0 = listOf<String>()
        var a1 = listOf<String>()
        for (i in groups.indices) {
            val word = words[i]
            val group = groups[i]
            if (group == 0) {
                a0 = a1 + word
            } else {
                a1 = a0 + word
            }
        }

        return if (a0.size > a1.size) a0 else a1
    }
}
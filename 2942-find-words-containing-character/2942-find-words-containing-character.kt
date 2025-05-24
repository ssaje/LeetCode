class Solution {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        val answer = mutableListOf<Int>()
        for (i in words.indices) {
            val word = words[i]
            if (x in word) {
                answer += i
            }
        }

        return answer
    }
}
class Solution {
    fun commonChars(words: Array<String>): List<String> {
        val counts = Array(words.size) { mutableMapOf<Char, Int>() }
        for (i in words.indices) {
            for (ch in words[i]) {
                counts[i][ch] = (counts[i][ch] ?: 0) + 1
            }
        }

        val answer = mutableListOf<String>()
        outer@ for (ch in 'a'..'z') {
            var min = Int.MAX_VALUE
            for (i in counts.indices) {
                val count = counts[i][ch]
                if (count == null) {
                    continue@outer
                }

                min = min.coerceAtMost(count)
            }

            repeat(min) {
                answer += ch.toString()
            }
        }

        return answer
    }
}
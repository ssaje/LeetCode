class Solution {
    fun isCircularSentence(sentence: String): Boolean {
        val split = sentence.split(" ")
        if (split.first().first() != split.last().last()) {
            return false
        }

        for (i in 1..split.lastIndex) {
            if (split[i - 1].last() != split[i].first()) {
                return false
            }
        }

        return true
    }
}
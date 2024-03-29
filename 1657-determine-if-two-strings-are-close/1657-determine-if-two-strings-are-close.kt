class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }

        val countsByCharacter1 = word1
            .groupingBy { it }
            .eachCount()
        val countsByCharacter2 = word2
            .groupingBy { it }
            .eachCount()

        return countsByCharacter1.keys == countsByCharacter2.keys &&
            countsByCharacter1.values.sorted() == countsByCharacter2.values.sorted()
    }
}
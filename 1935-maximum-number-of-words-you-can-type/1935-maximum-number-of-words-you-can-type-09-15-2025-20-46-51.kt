class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val set = brokenLetters.toSet()
        return text.split(" ").count { it.all { it !in set } }
    }
}
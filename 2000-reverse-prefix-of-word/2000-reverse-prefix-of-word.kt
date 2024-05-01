class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        val pos = word.indexOfFirst { it == ch }
        if (pos == -1) {
            return word
        }

        return "${word.slice(0..pos).reversed()}${word.slice(pos+1..word.lastIndex)}"
    }
}
class Solution {
    fun firstPalindrome(words: Array<String>): String {
        for (word in words) {
            if (isPalindrome(word)) {
                return word
            }
        }

        return ""
    }

    private fun isPalindrome(word: String): Boolean {
        var i = (word.length - 1) / 2
        var j = word.length / 2
        while (0 <= i && j <= word.lastIndex) {
            if (word[i--] != word[j++]) {
                return false
            }
        }

        return true
    }
}
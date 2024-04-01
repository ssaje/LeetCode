class Solution {
    fun lengthOfLastWord(s: String): Int {
        return s
            .trimEnd()
            .takeLastWhile { it.isLetter() }
            .length
    }
}
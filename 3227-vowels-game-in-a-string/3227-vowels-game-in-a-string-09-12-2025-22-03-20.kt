class Solution {
    fun doesAliceWin(s: String): Boolean {
        return s.any { it in setOf('a', 'e', 'i', 'o', 'u') }
    }
}
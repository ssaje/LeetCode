class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val set = allowed.toSet()
        
        return words.count { word ->
            for (ch in word) {
                if (ch !in set) {
                    return@count false
                }
            }

            true
        }
    }
}
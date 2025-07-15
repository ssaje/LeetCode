class Solution {
    fun isValid(word: String): Boolean {
        if (word.length < 3) return false

        val countsByCh = word.groupingBy { it.lowercase() }.eachCount()
        var v = 0
        var c = 0
        countsByCh.forEach { (key, _) ->
            if (key in setOf("@", "#", "$")) return false
            else if (key in setOf("a", "e", "i", "o", "u")) v++
            else if (!key[0].isDigit()) c++
        }

        return c > 0 && v > 0
    }
}
class Solution {
    fun addSpaces(s: String, spaces: IntArray): String {
        return buildString {
            var lastIndex = 0
            for (space in spaces) {
                append(s.slice(lastIndex..<space))
                append(" ")
                lastIndex = space
            }

            append(s.substring(lastIndex))
        }
    }
}
class Solution {
    fun removeOccurrences(s: String, part: String): String {
        return buildString {
            for (ch in s) {
                append(ch)
                while (this.endsWith(part)) {
                    deleteRange(this.length - part.length, this.length)
                }
            }
        }
    }
}
class Solution {
    fun scoreOfString(s: String): Int {
        return s.zipWithNext()
            .fold(0) { acc, (a, b) -> acc + (a - b).absoluteValue }
    }
}
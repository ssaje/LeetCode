class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val starts = HashMap<Char, Int>()
        var max = -1
        for ((index, ch) in s.withIndex()) {
            if (ch in starts) {
                max = max.coerceAtLeast(index - starts[ch]!! - 1)
            } else {
                starts.put(ch, index)
            }
        }

        return max
    }
}
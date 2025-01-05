class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val sums = IntArray(s.length + 1)
        for ((start, end, direction) in shifts) {
            val delta = if (direction == 0) {
                -1
            } else {
                1
            }

            sums[start] = (sums[start] + delta + 26) % 26
            sums[end + 1] = (sums[end + 1] - delta + 26) % 26
        }

        return buildString {
            ensureCapacity(s.length)

            var acc = 0
            for (i in s.indices) {
                acc = (acc + sums[i] + 26) % 26
                append('a' + (s[i] - 'a' + acc) % 26)
            }
        }
    }
}
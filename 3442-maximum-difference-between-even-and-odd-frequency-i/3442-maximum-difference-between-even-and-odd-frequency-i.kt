class Solution {
    fun maxDifference(s: String): Int {
        var odd = 0
        var even = 100
        val counts = IntArray(26)
        for (ch in s) {
            counts[ch - 'a']++
        }

        for (count in counts) {
            if (count == 0) continue

            if (count % 2 == 1) {
                odd = maxOf(odd, count)
            } else {
                even = minOf(even, count)
            }
        }

        return odd - even
    }
}
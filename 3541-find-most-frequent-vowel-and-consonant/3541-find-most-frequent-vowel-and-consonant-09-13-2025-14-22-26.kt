class Solution {
    fun maxFreqSum(s: String): Int {
        val counts = IntArray(26)
        for (ch in s) {
            counts[ch - 'a']++
        }

        var vMax = 0
        var cMax = 0
        for (i in 0..<26) {
            if (i in vowels) vMax = maxOf(vMax, counts[i])
            else cMax = maxOf(cMax, counts[i])
        }

        return vMax + cMax
    }

    companion object {
        private val vowels = setOf('a', 'e', 'i', 'o', 'u').map { it - 'a' }
    }
}
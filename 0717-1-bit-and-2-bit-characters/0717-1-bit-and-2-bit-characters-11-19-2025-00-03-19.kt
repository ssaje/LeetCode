class Solution {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        val n = bits.size
        var i = 0
        while (i + 1 < n) {
            if (bits[i] == 1) i++
            i++
        }

        return i == n - 1
    }
}
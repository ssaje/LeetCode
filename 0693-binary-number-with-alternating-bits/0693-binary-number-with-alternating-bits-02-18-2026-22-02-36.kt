class Solution {
    fun hasAlternatingBits(n: Int): Boolean {
        val bits = n.toString(2)
        for (i in 1..<bits.length) {
            if (bits[i] == bits[i - 1]) return false
        }

        return true
    }
}
class Solution {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val codes = mutableSetOf<Int>()
        val total = 1 shl k
        val mask = total - 1
        var hash = 0
        for (i in 0..<s.length) {
            hash = ((hash shl 1) and mask) or (s[i] - '0')
            if (i >= k - 1) {
                codes += hash
                if (codes.size == total) return true
            }
        }

        return false
    }
}
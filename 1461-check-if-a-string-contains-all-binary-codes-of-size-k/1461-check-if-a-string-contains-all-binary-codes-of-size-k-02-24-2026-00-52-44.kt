class Solution {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val codes = mutableSetOf<String>()
        val total = 1 shl k
        for (i in k..s.length) {
            codes += s.slice(i-k..<i)
            if (codes.size == total) return true
        }

        return false
    }
}
class Solution {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val codes = mutableSetOf<String>()
        for (i in k..s.length) {
            codes += s.slice(i-k..<i)
        }

        return codes.size == (1 shl k)
    }
}
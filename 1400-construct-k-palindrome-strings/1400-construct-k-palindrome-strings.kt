class Solution {
    fun canConstruct(s: String, k: Int): Boolean {
        val counts = IntArray(26)
        for (ch in s) {
            counts[ch - 'a']++
        }

        var odd = 0
        var even = 0
        for (i in 0..<26) {
            if (counts[i] == 0) {
                continue
            }

            if (counts[i] % 2 == 0) {
                even++
            } else {
                odd++
            }
        }

        return odd - even <= k && k <= odd + even
    }
}
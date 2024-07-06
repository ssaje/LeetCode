class Solution {
    fun passThePillow(n: Int, time: Int): Int {
        val pos = time % (2 * (n - 1))

        return if (pos < n) {
            pos + 1
        } else {
            2 * n - pos - 1
        }
    }
}
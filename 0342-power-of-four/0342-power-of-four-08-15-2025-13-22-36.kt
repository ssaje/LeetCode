class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        if (n <= 0) return false

        var m = n
        while (m > 1 && m % 4 == 0) {
            m /= 4
        }

        return m == 1
    }
}
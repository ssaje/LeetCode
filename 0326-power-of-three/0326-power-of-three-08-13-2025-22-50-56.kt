class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        if (n <= 0) return false

        var m = n
        while (m > 1) {
            if (m % 3 != 0) break
            m /= 3
        }

        return m == 1
    }
}
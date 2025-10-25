class Solution {
    fun nextBeautifulNumber(n: Int): Int {
        var m = n + 1
        while (!isBalanced(m)) {
            m++
        }

        return m
    }

    private fun isBalanced(n: Int): Boolean {
        val counts = IntArray(10)
        var m = n
        while (m > 0) {
            counts[m % 10]++
            m /= 10
        }

        for (digit in 0..9) {
            if (counts[digit] != 0 && counts[digit] != digit) return false
        }

        return true
    }
}
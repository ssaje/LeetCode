class Solution {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        fun isSymmetric(digits: String): Boolean {
            if (digits.length % 2 == 1) {
                return false
            }

            val n = digits.length / 2
            return digits.slice(0..<n).sumOf { it.digitToInt() } == digits.slice(n..<digits.length).sumOf { it.digitToInt() }
        }

        return (low..high).count { isSymmetric(it.toString()) }
    }
}
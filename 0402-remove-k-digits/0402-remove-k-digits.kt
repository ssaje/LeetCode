class Solution {
    fun removeKdigits(num: String, k: Int): String {
        val digits = CharArray(num.length + 1)
        digits[0] = '0'

        var lastIndex = 0
        var rest = k
        for (digit in num) {
            while (rest > 0 && digits[lastIndex] > digit) {
                --rest
                --lastIndex
            }

            digits[++lastIndex] = digit
        }

        return digits
            .asSequence()
            .take(lastIndex + 1 - rest)
            .joinToString("")
            .trimStart('0')
            .ifEmpty { "0" }
    }
}
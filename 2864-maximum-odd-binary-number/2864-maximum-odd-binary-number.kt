class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        var ones = 0
        var zeros = 0
        for (ch in s) {
            if (ch == '0') {
                zeros++
            } else {
                ones++
            }
        }

        return "1".repeat(ones - 1) + "0".repeat(zeros) + "1"
    }
}
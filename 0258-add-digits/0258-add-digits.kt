class Solution {
    fun addDigits(num: Int): Int {
        return num - 9 * ((num - 1) / 9)
    }
}
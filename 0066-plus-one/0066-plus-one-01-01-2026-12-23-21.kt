import java.math.BigInteger

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        return digits.joinToString("").toBigInteger().add(BigInteger.ONE).toString().map { it.digitToInt() }.toIntArray()
    }
}
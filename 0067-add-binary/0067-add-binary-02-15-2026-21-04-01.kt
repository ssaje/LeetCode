import java.math.BigInteger

class Solution {
    fun addBinary(a: String, b: String): String {
        return (BigInteger(a, 2) + BigInteger(b, 2)).toString(2)
    }
}
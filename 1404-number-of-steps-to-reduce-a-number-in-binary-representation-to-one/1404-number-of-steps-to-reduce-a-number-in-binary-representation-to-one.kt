class Solution {
    fun numSteps(s: String): Int {
        var answer = 0
        var n = BigInteger(s, 2)
        while (n > BigInteger.ONE) {
            answer++

            if (n and BigInteger.ONE == BigInteger.ONE) {
                n += BigInteger.ONE
            } else {
                n = n shr 1
            }
        }

        return answer
    }
}
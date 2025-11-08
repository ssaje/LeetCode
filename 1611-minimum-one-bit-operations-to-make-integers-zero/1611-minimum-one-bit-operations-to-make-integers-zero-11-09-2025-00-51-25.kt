class Solution {
    fun minimumOneBitOperations(n: Int): Int {
        if (n == 0) return 0

        var k = 0
        var m = 1
        while (2 * m <= n) {
            m *= 2
            k++
        }

        return (1 shl (k + 1)) - 1 - minimumOneBitOperations(n xor m)
    }
}
class Solution {
    fun countPrimeSetBits(left: Int, right: Int): Int {
        return (left..right).count { it.countOneBits() in primes }
    }

    companion object {
        private val primes = setOf(
            2, 3, 5, 7,
            11, 13, 17, 19,
        )
    }
}
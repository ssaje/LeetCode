class Solution {
    fun numOfSubarrays(arr: IntArray): Int {
        var answer = 0
        var sum = 0
        val counts = IntArray(2)
        counts[0] = 1

        for (num in arr) {
            sum = (sum + num) % MOD
            val parity = sum % 2

            answer = (answer + counts[1 - parity]) % MOD
            counts[parity]++
        }

        return answer
    }

    companion object {
        private const val MOD = 1_000_000_000 + 7
    }
}
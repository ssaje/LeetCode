class Solution {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val countsByRemainder = mutableMapOf<Int, Int>(0 to 1)

        var sum = 0
        for (num in nums) {
            sum = (sum + num % k + k) % k
            countsByRemainder[sum] = (countsByRemainder[sum] ?: 0) + 1
        }

        return countsByRemainder
            .values
            .sumOf { it * (it - 1) / 2 }
    }
}
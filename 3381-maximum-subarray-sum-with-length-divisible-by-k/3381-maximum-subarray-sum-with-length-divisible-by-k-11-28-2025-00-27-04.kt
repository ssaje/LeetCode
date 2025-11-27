class Solution {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val prev = mutableMapOf<Int, Long>()
        prev[0] = 0L

        var sum = 0L
        var answer = Long.MIN_VALUE
        for ((index, value) in nums.withIndex()) {
            sum += value

            val length = (index + 1) % k
            if (length in prev) {
                answer = maxOf(answer, sum - prev[length]!!)
                prev[length] = minOf(prev[length]!!, sum)
            } else {
                prev[length] = sum
            }
        }

        return answer
    }
}
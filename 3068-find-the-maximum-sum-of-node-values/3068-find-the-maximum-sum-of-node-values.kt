class Solution {
    fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
        var answer = 0L
        var count = 0
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (num in nums) {
            answer += num

            val diff = (num xor k) - num
            if (diff > 0) {
                min = min.coerceAtMost(diff)
                count++
                answer += diff
            } else {
                max = max.coerceAtLeast(diff)
            }
        }

        return when (count % 2) {
            0 -> answer
            else -> maxOf(answer + max, answer - min)
        }
    }
}
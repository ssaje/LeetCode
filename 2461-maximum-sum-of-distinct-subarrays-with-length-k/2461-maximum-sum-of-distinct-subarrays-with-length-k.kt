class Solution {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        val counts = mutableMapOf<Int, Int>()
        var count = 0
        var sum = 0L
        var answer = 0L
        for (e in nums.indices) {
            val num = nums[e]

            sum += num
            counts[num] = (counts[num] ?: 0) + 1
            if (counts[num] == 1) {
                ++count
            }

            if (e >= k) {
                val prevNum = nums[e - k]

                sum -= prevNum
                counts[prevNum] = (counts[prevNum] ?: 0) - 1
                if (counts[prevNum] == 0) {
                    --count
                }
            }

            if (count == k) {
                answer = answer.coerceAtLeast(sum)
            }
        }

        return answer
    }
}
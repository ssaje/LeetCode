class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }

        val counts = Array(nums.size) { mutableMapOf<Long, Int>() }
        var answer = 0
        for (i in 1..nums.lastIndex) {
            for (j in 0 until i) {
                val diff = nums[i].toLong() - nums[j]
                val curr = counts[i][diff] ?: 0
                val prev = counts[j][diff] ?: 0
                
                answer += prev
                counts[i][diff] = curr + prev + 1
            }
        }

        return answer
    }
}
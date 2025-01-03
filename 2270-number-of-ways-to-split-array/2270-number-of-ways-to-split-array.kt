class Solution {
    fun waysToSplitArray(nums: IntArray): Int {
        val sum = nums.sumOf { it.toLong() }
        var acc = 0L
        var answer = 0
        for (i in 0..<nums.lastIndex) {
            acc += nums[i]
            if (2 * acc >= sum) {
                answer++
            }
        }

        return answer
    }
}
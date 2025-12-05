class Solution {
    fun countPartitions(nums: IntArray): Int {
        val total = nums.sum()
        var answer = 0
        var sum = 0
        for (i in 0..<nums.size-1) {
            sum += nums[i]
            if ((total - sum * 2).absoluteValue % 2 == 0) answer++
        }

        return answer
    }
}
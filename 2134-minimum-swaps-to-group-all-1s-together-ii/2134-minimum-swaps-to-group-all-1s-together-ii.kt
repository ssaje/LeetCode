class Solution {
    fun minSwaps(nums: IntArray): Int {
        val total = nums.count { it == 1 }
        var current = 0
        for (i in 0..<total) {
            current += nums[i]
        }

        var answer = total - current
        var e = total
        for (s in 0..nums.lastIndex) {
            current += nums[e % nums.size] - nums[s]
            e++

            answer = answer.coerceAtMost(total - current)
        }

        return answer
    }
}
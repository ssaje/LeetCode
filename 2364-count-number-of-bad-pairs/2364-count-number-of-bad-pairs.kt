class Solution {
    fun countBadPairs(nums: IntArray): Long {
        // j - nums[j] != i - nums[i]
        val counts = mutableMapOf<Int, Int>()
        var answer = 0L
        for (i in nums.indices) {
            val c = i - nums[i]
            val count = counts[c] ?: 0
            answer += i - count
            counts[c] = count + 1
        }

        return answer
    }
}
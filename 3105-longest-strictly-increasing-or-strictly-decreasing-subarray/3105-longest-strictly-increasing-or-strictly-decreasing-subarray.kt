class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        var answer = 1
        var count = 1
        for (i in 1..nums.lastIndex) {
            if (nums[i - 1] < nums[i]) {
                count++
                answer = answer.coerceAtLeast(count)
            } else {
                count = 1
            }
        }

        count = 1
        for (i in 1..nums.lastIndex) {
            if (nums[i - 1] > nums[i]) {
                count++
                answer = answer.coerceAtLeast(count)
            } else {
                count = 1
            }
        }

        return answer
    }
}
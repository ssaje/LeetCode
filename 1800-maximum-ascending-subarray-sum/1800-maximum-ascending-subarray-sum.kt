class Solution {
    fun maxAscendingSum(nums: IntArray): Int {
        var answer = nums[0]
        var sum = nums[0]
        for (i in 1..nums.lastIndex) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i]
                answer = answer.coerceAtLeast(sum)
            } else {
                sum = nums[i]
            }
        }

        return answer
    }
}
class Solution {
    fun maxAdjacentDistance(nums: IntArray): Int {
        var answer = abs(nums[0] - nums.last())
        for (i in 1..<nums.size) {
            answer = maxOf(answer, abs(nums[i] - nums[i - 1]))
        }

        return answer
    }
}
class Solution {
    fun maximumDifference(nums: IntArray): Int {
        var answer = -1
        for (i in nums.indices) {
            for (j in i+1..<nums.size) {
                if (nums[i] < nums[j]) {
                    answer = maxOf(answer, nums[j] - nums[i])
                }
            }
        }

        return answer
    }
}
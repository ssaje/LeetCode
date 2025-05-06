class Solution {
    fun buildArray(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        for (i in nums.indices) {
            answer[i] = nums[nums[i]]
        }

        return answer
    }
}
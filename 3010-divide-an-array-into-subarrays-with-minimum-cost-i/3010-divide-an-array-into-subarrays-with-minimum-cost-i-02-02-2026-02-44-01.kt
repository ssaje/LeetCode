class Solution {
    fun minimumCost(nums: IntArray): Int {
        val sorted = nums.drop(1).sorted()
        return nums[0] + sorted[0] + sorted[1]
    }
}
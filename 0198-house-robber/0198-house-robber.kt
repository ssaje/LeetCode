class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }

        val d = IntArray(nums.size)
        d[0] = nums[0]
        d[1] = max(nums[0], nums[1])
        
        for (i in 2..nums.lastIndex) {
            d[i] = max(nums[i] + d[i - 2], d[i - 1])
        }

        return d[nums.lastIndex]
    }
}